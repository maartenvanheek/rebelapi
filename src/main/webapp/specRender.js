/**
 * Created by bc27wo on 22/11/2016.
 */
var SpecRenderer = function () {
    var state_regex = /state_([a-zA-Z]+)/;
    var event_regex = /event_([a-zA-Z]+)_([a-zA-Z]+)_([a-zA-Z]+)/;

    var Specification = function (fqn, name, documentation, modifier, inheritsFrom, extendedBy,
                                  fields, events, states, transitions, externalMachines,
                                  transitionsToExternalMachines, transitionsFromExternalMachines) {
        this.fqn = fqn;
        this.name = name;
        this.documentation = documentation;
        this.modifier = modifier;
        this.inheritsFrom = inheritsFrom;
        this.extendedBy = extendedBy;
        this.fields = fields;
        this.events = events;
        this.states = states;
        this.transitions = transitions;
        this.externalMachines = externalMachines;
        this.transitionsToExternalMachines = transitionsToExternalMachines;
        this.transitionsFromExternalMachines = transitionsFromExternalMachines
    };

    var currentState = function (currentState) {
        this.currentState = currentState;
    };

    function buildGraph(specification, currentState) {
        function guid() {
            function s4() {
                return Math.floor((1 + Math.random()) * 0x10000)
                    .toString(16)
                    .substring(1);
            }

            return s4() + s4() + '-' + s4() + '-' + s4() + '-' +
                s4() + '-' + s4() + s4() + s4();
        }

        // Create a new directed graph
        var g = new dagreD3.graphlib.Graph({compound: true}).setGraph({rankDir: "lr"});

        // Create group for specification
        var groupId = guid();
        var groupLabel = "<em>" + specification.name + "</em>";
        if ("name" in specification.inheritsFrom) {
            if (specification.inheritsFrom.url !== "?") {
                groupLabel += "<span class='inheritsFrom'>inherits from <a href='#" + specification.inheritsFrom.url + "'>" + specification.inheritsFrom.name + "</a></span>";
            } else {
                groupLabel += "<span class='inheritsFrom'>inherits from " + specification.inheritsFrom.name + "</span>";
            }
        }

        if (specification.extendedBy.length > 0) {
            groupLabel += "<span class='extendedBy'>extended by ";
            specification.extendedBy.forEach(function (e, index) {
                if ("url" in e) {
                    groupLabel += "<a href='#" + e.url + "'>" + e.name + "</a>";
                } else {
                    groupLabel += e.name;
                }

                groupLabel += index < specification.extendedBy.length - 1 ? ", " : "";
            });
        }

        groupLabel = (specification.modifier === "abstract" ? "<p>&lt;&lt;abstract&gt;&gt;</p>" :
                specification.modifier === "external" ? "<p>&lt;&lt;external&gt;&gt;</p>" :
                    "") + groupLabel;

        g.setNode(groupId, {
            labelType: "html",
            clusterLabelPos: "top",
            clusterLabelColor: "#000",
            label: groupLabel,
            class: "groupLabel"
        });

        // add the fields of the specification
        if (specification.fields.length > 0) {
            var fieldsId = guid();
            var fieldsLabel = "<table><thead><tr><th>Fields</th></tr></thead><tbody>";
            specification.fields.forEach(function (field) {
                fieldsLabel += "<tr><td>" + field.name + ":</td><td>" + field.type + "</td></tr>";
            });
            fieldsLabel += "</tbody></table>";

            g.setNode(fieldsId, {
                labelType: "html",
                label: fieldsLabel,
                shape: "rect",
                class: "fields"
            });
            g.setParent(fieldsId, groupId);
        }

        // Add states
        specification.states.forEach(function (state) {
            g.setNode(state.id, {
                label: state.label,
                shape: state.initial ? "initial" : state.final ? "final" : "state",
                style: state.id === currentState ? state.final ? "fill: #f00" : "fill: #afa" : state.initial || state.final ? "fill: #000" : "fill: #fff",
                class: "stateNode"
            });
            g.setParent(state.id, groupId);
        });

        // add events
        specification.events.forEach(function (event) {
            g.setNode(event.id, {
                label: event.label,
                shape: "rect",
                class: "edgeNode",
                title: event.id,
                doc: "doc" in event ? event.doc : "",
                config: "config" in event ? event.config : [],
                params: "params" in event ? event.params : [],
                preconditions: "preconditions" in event ? event.preconditions : [],
                postconditions: "postconditions" in event ? event.postconditions : [],
                sync: "sync" in event ? event.sync : []
            });
            g.setParent(event.id, groupId);
        });

        function getLabelOfExternalMachine(external) {
            var label = external.url !== "?" ? "<a href='#" + external.url + "'>" + external.label + "</a>" : external.label;
            switch (external.referenceType) {
                case "in":
                    label = "<p>&lt;&lt;is referenced by&gt;&gt;</p>" + label;
                    break;
                case "out":
                    label = "<p>&lt;&lt;references&gt;&gt;</p>" + label;
                    break;
                case "both":
                    label = "<p>&lt;both references and is referenced by&gt;&gt;</p>" + label;
                    break;
            }
            return label;
        }

        // add external machines
        specification.externalMachines.forEach(function (external) {
            g.setNode(external.id, {
                labelType: "html",
                label: getLabelOfExternalMachine(external),
                class: "externalMachine " + external.referenceType,
                shape: "rect"
            });
        });

        // Set up internal edges
        specification.transitions.forEach(function (trans) {
            g.setEdge(trans.from, trans.via, {label: "", arrowhead: "undirected", lineInterpolate: "basis"});
            g.setEdge(trans.via, trans.to, {label: "", lineInterpolate: "basis"});
        });

        // set up external edges
        specification.transitionsToExternalMachines.forEach(function (trans) {
            g.setEdge(trans.from, trans.to, {class: "syncTo", lineInterpolate: "basis"});
        });

        specification.transitionsFromExternalMachines.forEach(function (trans) {
            g.setEdge(trans.fromMachine, trans.to, {class: "syncFrom", lineInterpolate: "basis"});
        });


        return g;
    }

    var renderSpecification = function (specification, currentState, svgDomElement) {
        var g = buildGraph(specification, currentState);

        svgDomElement.select("g").remove();
        svgDomElement.insert("g");

        var inner = svgDomElement.select("g");

        // Set up zoom support
        var zoom = d3.behavior.zoom().on("zoom", function () {
            inner.attr("transform", "translate(" + d3.event.translate + ")" +
                "scale(" + d3.event.scale + ")");
        });
        svgDomElement.call(zoom);

        // Create the renderer
        var render = new dagreD3.render();

        render.shapes().initial = function (parent, bbox, node) {
            var w = bbox.width,
                h = bbox.height,
                shapeSvg = parent.insert("circle")
                    .attr("cx", 0)
                    .attr("cy", 0)
                    .attr("r", 10)
                    .attr("label", "")
                    .attr("class", "initial");
            node.intersect = function (point) {
                return dagreD3.intersect.circle(node, 10, point);
            };

            return shapeSvg;
        };

        render.shapes().state = function (parent, bbox, node) {
            var w = bbox.width,
                h = bbox.height,
                shapeSvg = parent.insert("circle")
                    .attr("cx", 0)
                    .attr("cy", 0)
                    .attr("r", 50)
                    .attr("title", "STATE")
                    .attr("class", "state")
                    .attr("stroke", "#fff");

            node.intersect = function (point) {
                return dagreD3.intersect.circle(node, 10, point);
            };

            return shapeSvg;
        };

        render.shapes().final = function (parent, bbox, node) {
            var w = bbox.width,
                h = bbox.height,
                shapeSvg = parent.insert("g");

            shapeSvg.insert("circle")
                .attr("cx", 0)
                .attr("cy", 0)
                .attr("r", 10)
                .attr("title", "FINAL")
                .attr("stroke", "#000")
                .attr("fill-opacity", "0")
                .attr("label", "")
                .attr("class", "final");

            shapeSvg.insert("circle")
                .attr("cx", 0)
                .attr("cy", 0)
                .attr("r", 6)
                .attr("label", "");

            node.intersect = function (point) {
                return dagreD3.intersect.circle(node, 10, point);
            };

            return shapeSvg;
        };

        var styleTooltip = function (edgeNode) {
            function createPart(title, items) {
                // this function is called upon rendering for all relevant items (not upon mouseover)
                // console.log("dbg: styleTooltip");
                var result = "<h1>" + title + "</h1>";
                for (var i = 0; i < items.length; i++) {
                    result += items[i];
                }
                return result;
            }

            function preprocessStatements(origItems) {
                var items = [];
                origItems.forEach(function (o) {
                    var item = ((o.doc !== undefined) ? "<p>" + micromarkdown.parse(o.doc) + "</p>" : "") +
                        ((o.code !== undefined) ? micromarkdown.parse("```" + o.code + "```") : "");
                    items.push(item);
                });

                return items;
            }

            var content = edgeNode.doc !== "" ? edgeNode.doc + " \n" : "";

            if (edgeNode.params.length > 0) {
                var items = [];
                edgeNode.params.forEach(function (p) {
                    items.push(micromarkdown.parse("```" + p.name + ": " + p.type + "```"));
                });
                content += createPart("Transition parameters", items);
            }
            content += edgeNode.preconditions.length > 0 ? createPart("Preconditions", preprocessStatements(edgeNode.preconditions)) : "";
            content += edgeNode.postconditions.length > 0 ? createPart("Postconditions", preprocessStatements(edgeNode.postconditions)) : "";
            content += edgeNode.sync.length > 0 ? createPart("Synchronized events", preprocessStatements(edgeNode.sync)) : "";
            // console.log(content);
            return content;
        };

        // Run the renderer. This is what draws the final graph.
        render(inner, g);

        // tooltips
        inner.selectAll("g.node.edgeNode")
            .attr("title", function (v) {
                return styleTooltip(g.node(v));
            })
            .each(function (v) {
                // dbg: this function is called upon generation of the graph, once for each tooltip
                // $(this).tipsy({gravity: "w", opacity: 0.8, html: true});
                // $(this).tooltip({content: v});
                $(this).tooltip({
                    content: function () {
                        return v;
                    }
                });
            });
        /*
         // THIS DOES NOT WORK
         inner.selectAll("g.node.edgeNode")
         .on("mouseover", function (){
         console.log("mouseover");
         tooltip.style("opacity", "1");
         });*/

        // select only edgenodes (i.e. transition label) that has FROM currentState
        inner.selectAll("g.node.edgeNode")
            .filter(function (id) {
                if(state_regex.exec(currentState)[1] === event_regex.exec(id)[1]){
                    console.debug("currentState: ", currentState, "id: ", id);
                }
                return state_regex.exec(currentState)[1] === event_regex.exec(id)[1];
            })
            .on("click", function (id) {
                console.debug("Node name: ", g.node(id).params);
                if (g.node(id).params.length > 0) {
                    console.info("Parameters needed");
                    console.debug("Params: ", g.node(id).params);
                    vm.params = g.node(id).params;
                    var $uibModalInstance = $uibModal.open({
                        animation: true,
                        templateUrl: 'transModal.tpl.html',
                        controller: 'transitionCtrl',
                        controllerAs: 'tvm',
                        resolve: {
                            params: function () {
                                return vm.params;
                            }
                        }
                    });
                    $uibModalInstance.result.then(function (results) {
                        if (results) {
                            console.debug("Modal results: ", results);
                            updateState(id, results)
                        }
                        else{
                            console.debug("No results");
                        }
                    }, function(error){
                        console.error("error: ", error);
                    })
                }
                else{
                    console.debug("No params needed");
                    updateState(id, undefined)
                }

            });

        String.prototype.toProperCase = function () {
            return this.replace(/\w\S*/g, function(txt){return txt.charAt(0).toUpperCase() + txt.substr(1).toLowerCase();});
        };

        function updateState(id, body){
            var transition = event_regex.exec(id)[2].toProperCase();
            var nextState = "state_" + event_regex.exec(id)[3];

            // TODO: do the actual post
            window.alert('POST to' + vm.server + vm.apiPrefix + vm.selectedSpec.name + '/' + vm.machineId + '/' + transition);
            console.debug('post body: ', body);
            currentState = nextState;
            showSpec(currentState);
            $http.post(vm.server + vm.apiPrefix + vm.selectedSpec.name + '/' + vm.machineId + '/' + transition, body)
                .then(function(results){
                    console.debug('process results from HTTP POST and update state');

                }, function (error){
                    console.error("Error updating state", error);
                });
        }

        // reset graph with click on init node
        inner.selectAll("g.node.stateNode")
            .filter(function (id) {
                return state_regex.exec(id)[1] === "init";
            })
            .on("click", function (id) {
                $http.get(vm.server + vm.apiPrefix + vm.selectedSpec.name + '/')
                    .then(function(results){
                        console.debug('api call: Retrieve specification data');
                        vm.specData = results.data;
                    }, function(error){
                        console.error("Could not retrieve specs for id ", id, error);
                    });
                currentState = id;
                showSpec(currentState);
            });

        var initialPlacement = function (svgViewport) {
            $log.debug("initial place: ", svgViewport.width(), svgViewport.height());
            var viewportWidth = svgViewport.width();
            var viewportHeight = svgViewport.height();

            g.initialScale = 1;
            if (viewportWidth > g.graph().width) {
                if (viewportHeight < g.graph().height) {
                    g.initialScale = (1 / (g.graph().height + 20)) * viewportHeight;
                }
            } else {
                g.initialScale = (1 / (g.graph().width + 20)) * viewportWidth;
            }

            zoom
                .translate([(viewportWidth - g.graph().width * g.initialScale) / 2,
                    (viewportHeight - g.graph().height * g.initialScale) / 2])
                .scale(g.initialScale)
                .event(svgDomElement);
        };

        return {
            // graph: g, // this return makes the svg#traph size down to exactly the rectangle size
            // initialPlacement: initialPlacement,
            // currentState: currentState
        }
    };

    return {
        Specification: Specification,
        currentState: currentState,
        render: renderSpecification
    }
}();