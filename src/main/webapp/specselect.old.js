/**
 * Created by bc27wo on 09/11/2016.
 */
'use strict';
var app = angular.module('visualApp.selection', []);

app.controller('specCtrl', ['$log', '$uibModal', '$http', '$window', function ($log, $uibModal, $http, $window) {
    var vm = this;

    vm.specs = specs;
    vm.showSpec = showSpec;
    vm.startSpec = startSpec;
    vm.transition = transition;
    vm.toggleDev = toggleDev;

    vm.apitest = apitest;
    vm.reset = reset;

    // maybe need a prefix for the api?
    vm.server = 'http://localhost:8080/';
    vm.apiPrefix = '';
    vm.machineId = 1; //TODO: not sure yet where we get/store this id
    vm.specData = undefined; //TODO: this is meant to come from HTTP GET
    vm.devmode = true;

    //default spec (so you don't have to pick one always)
    vm.selectedSpec = specs[0];

    vm.transitionId = undefined;

    // initial size of graph (not relevant??)
    vm.h = $window.innerHeight;
    vm.w = $window.innerWidth;

    // track previous states to show progress
    vm.previousState = [];
    vm.availableEvent = [];

    // placeholder text (I am still confused why the graph doesn't fill full width, but text does...)
    vm.lipsum = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Peccata paria. Sed ego in hoc resisto; Sed residamus, inquit, si placet. Cum praesertim illa perdiscere ludus esset. Duo Reges: constructio interrete. Sed ego in hoc resisto; In qua quid est boni praeter summam voluptatem, et eam sempiternam? At iam decimum annum in spelunca iacet.          Comprehensum, quod cognitum non habet? Murenam te accusante defenderem. Ut optime, secundum naturam affectum esse possit. Quae qui non vident, nihil umquam magnum ac cognitione dignum amaverunt. Etenim semper illud extra est, quod arte comprehenditur. Post enim Chrysippum eum non sane est disputatum. Tum Quintus: Est plane, Piso, ut dicis, inquit";

    function toggleDev() {
        $log.debug("Devmode is now ", vm.devmode);
        vm.devmode ? $log.debug("Yes") : $log.debug("No.");
        vm.devmode ? changeColour('dev') : changeColour();
    }

    function apitest() {
        var url = vm.server + vm.apiPrefix + vm.selectedSpec.name + '/' + vm.machineId;
        $log.debug("Attempting to GET " + url);
        $http.get(url)
            .then(function (results) {
                $log.info("GET succes", results);
            }, function (error) {
                $log.warn("GET failed: ", error);
            });
    }

    function reset() {
        vm.previousState = [];
        vm.availableEvent = [];
        $http.get(vm.server + vm.apiPrefix + vm.selectedSpec.name + '/')
            .then(function (results) {
                console.debug('api call: Retrieve specification data');
                vm.specData = results.data;
            }, function (error) {
                console.error("Could not retrieve specs ", error);
            });
        showSpec();
    }

    function showSpec(currentState) {
        if (currentState === undefined) {
            currentState = "state_init";
        }
        var svg = d3.select("svg");
        var g = (vm.selectedSpec !== undefined) ? SpecRenderer.render(vm.selectedSpec, currentState, svg) : SpecRenderer.render(noSpecFound, null, svg);
    }

    function startSpec() {
        // this should fire the initial spec

    }

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

        var glksfdgj = function(){};

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


            var drawInit = function (state) {
                g.setNode(state.id, {
                    shape: "initial",
                    label: "",
                    class: "initNode"
                });
                // basically you don't want this
                // if (state.id === currentState) {
                //     g.setNode(state.id, {
                //         shape: "initial",
                //         label: "",
                //         class: "initNode",
                //         style: "fill: lightgreen"
                //     });
                // }
                g.setParent(state.id, groupId);
            };

            var drawFinal = function (state) {
                g.setNode(state.id, {
                    shape: "final",
                    label: "",
                    style: "fill: black"
                });
                if (state.id === currentState) {
                    g.setNode(state.id, {
                        shape: "final",
                        label: "",
                        style: "fill: red"
                    })
                }
                g.setParent(state.id, groupId);
            };

            var drawState = function (state) {
                // ok so you can draw them as shape circle (and they get the radius from the label size)
                // or you can do it as the initial/final state drawing... but then they won't have labels :/
                g.setNode(state.id, {
                    shape: "circle",
                    // bbox: "width: 500, height: 500",
                    label: state.label,
                    class: "stateNode"
                });
                if (state.id === currentState) {
                    g.setNode(state.id, {
                        shape: "circle",
                        class: "currentNode",
                        label: state.label
                    })
                }
                else if (vm.previousState.indexOf(state.id) > -1) {
                    g.setNode(state.id, {
                        shape: "circle",
                        class: "previousNode",
                        label: state.label
                    })
                }
                g.setParent(state.id, groupId);
            };

            specification.states.forEach(function (state) {
                if (state.initial) {
                    drawInit(state)
                }
                else if (state.final) {
                    drawFinal(state)
                }
                else {
                    drawState(state);
                }
                // REVIEW: callback and assign g.setparent here instead?
                // g.setParent(state.id, groupId);
            });
            var drawEvent = function (event) {
                // $log.debug("drawEvent id:_"+event.id+"_");
                // $log.debug("available: ", vm.availableEvent);
                // $log.debug("previous: ", vm.previousState);

                if (vm.previousState.indexOf(event.id) > -1) {
                    g.setNode(event.id, {
                        shape: "circle",
                        class: "previousEdge",
                        label: event.label,
                        doc: "doc" in event ? event.doc : "",
                        config: "config" in event ? event.config : [],
                        params: "params" in event ? event.params : [],
                        preconditions: "preconditions" in event ? event.preconditions : [],
                        postconditions: "postconditions" in event ? event.postconditions : [],
                        sync: "sync" in event ? event.sync : []
                    })
                }
                else if (state_regex.exec(currentState)[1] === event_regex.exec(event.id)[1]) {
                    g.setNode(event.id, {
                        shape: "circle",
                        class: "availableEdge",
                        label: event.label,
                        doc: "doc" in event ? event.doc : "",
                        config: "config" in event ? event.config : [],
                        params: "params" in event ? event.params : [],
                        preconditions: "preconditions" in event ? event.preconditions : [],
                        postconditions: "postconditions" in event ? event.postconditions : [],
                        sync: "sync" in event ? event.sync : []
                    });
                }
                else {
                    g.setNode(event.id, {
                        shape: "circle",
                        class: "unavailableEdge",
                        label: event.label,
                        doc: "doc" in event ? event.doc : "",
                        config: "config" in event ? event.config : [],
                        params: "params" in event ? event.params : [],
                        preconditions: "preconditions" in event ? event.preconditions : [],
                        postconditions: "postconditions" in event ? event.postconditions : [],
                        sync: "sync" in event ? event.sync : []
                    });
                }
                g.setParent(event.id, groupId);
            };

            // add events
            specification.events.forEach(function (event) {
                drawEvent(event);
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
                        label = "<p>&lt;&lt;both references and is referenced by&gt;&gt;</p>" + label;
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
                if (vm.previousState.indexOf(trans.via) > -1) {
                    g.setEdge(trans.from, trans.via, {
                        arrowhead: "undirected",
                        lineInterpolate: "basis",
                        class: "previous"
                    });
                    g.setEdge(trans.via, trans.to, {
                        lineInterpolate: "basis",
                        class: "previous"
                        // arrowheadStyle: "stroke: none; fill: blue",
                        // arrowheadClass: "arrowhead"
                    });
                }
                else {
                    g.setEdge(trans.from, trans.via, {label: "", arrowhead: "undirected", lineInterpolate: "basis"});
                    g.setEdge(trans.via, trans.to, {label: "", lineInterpolate: "basis"});
                }
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

            render.shapes().final = function (parent, bbox, node) {
                $log.debug("render final");
                $log.debug("parent: ", parent);
                $log.debug("bbox: ", bbox);
                $log.debug("node: ", node);
                var w = bbox.width,
                    h = bbox.height,
                    shapeSvg = parent.insert("g");

                shapeSvg.insert("circle")
                    .attr("cx", 0)
                    .attr("cy", 0)
                    .attr("r", 10)
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
                    var result = "<h2>" + title + "</h2><table class='tiptable'>";
                    for (var i = 0; i < items.length; i++) {
                        result += items[i];
                    }
                    result += "</table>";
                    return result;
                }

                function preprocessStatements(origItems) {
                    var items = [];
                    origItems.forEach(function (o) {
                        var item = ((o.doc !== undefined) ? "<tr><td><h4>" + o.doc + "</h4></td></tr>" : "") +
                            ((o.code !== undefined) ? "<tr><td><code>" + o.code + "</code></td></tr>" : "");
                        items.push(item);
                    });

                    return items;
                }

                // this is basically the tooltip title
                var content = edgeNode.doc !== "" ? "<h2>" + edgeNode.doc + "</h2>" : "";

                if (edgeNode.params.length > 0) {
                    var items = [];
                    items.push("<thead><th>Parameter</th><th>Type</th></thead>");
                    edgeNode.params.forEach(function (p) {
                        items.push("<tr><td>" + p.name + "</td><td>" + p.type + "</td></tr>");
                    });
                    content += createPart("Transition parameters", items);
                }
                content += edgeNode.preconditions.length > 0 ? createPart("Preconditions", preprocessStatements(edgeNode.preconditions)) : "";
                content += edgeNode.postconditions.length > 0 ? createPart("Postconditions", preprocessStatements(edgeNode.postconditions)) : "";
                content += edgeNode.sync.length > 0 ? createPart("Synchronized events", preprocessStatements(edgeNode.sync)) : "";
                return content;
            };

            // Run the renderer. This is what draws the final graph.
            $log.debug("before render(inner, g)");
            $log.debug("inner: ", inner);
            $log.debug("g: ", g);
            render(inner, g);
            $log.debug("after render(inner, g)");

            // tooltips
            inner.selectAll("g.node.availableEdge, g.node.previousEdge, g.node.unavailableEdge")
                .attr("title", function (v) {
                    return styleTooltip(g.node(v));
                })
                .each(function (v) {
                    $(this).tipsy({gravity: "w", opacity: 0.8, html: true});
                });

            // select only available events
            inner.selectAll("g.node.availableEdge")
            // filter is not needed if edge class is specifig
            // .filter(function (id) {
            //     return state_regex.exec(currentState)[1] === event_regex.exec(id)[1];
            // })
            // // TODO: ng 'start action' should trigger this event also
                .on("click", function (id) {
                    if (g.node(id).params.length > 0) {
                        $log.info("Parameters needed");
                        $log.debug("Params: ", g.node(id).params);
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
                                $log.debug("Modal results: ", results);
                                updateState(id, results)
                            }
                            else {
                                $log.debug("No results");
                            }
                        }, function (error) {
                            console.error("error: ", error);
                        })
                    }
                    else {
                        console.debug("No params needed");
                        updateState(id, undefined)
                    }

                });

            String.prototype.toProperCase = function () {
                return this.replace(/\w\S*/g, function (txt) {
                    return txt.charAt(0).toUpperCase() + txt.substr(1).toLowerCase();
                });
            };

            function updateState(id, body) {
                $log.debug("I'm going to update state");
                var transition = event_regex.exec(id)[2].toProperCase();
                var nextState = "state_" + event_regex.exec(id)[3];

                // TODO: do the actual post
                // window.alert('POST to' + vm.server + vm.apiPrefix + vm.selectedSpec.name + '/' + vm.machineId + '/' + transition);
                // $http.post(vm.server + vm.apiPrefix + vm.selectedSpec.name + '/' + vm.machineId + '/' + transition, body)
                $http.get('http://localhost:8080/IngNLAccount/1/')
                // $http.post('http://localhost:8080/OnUsCreditTransferNL/1/Create', body) //it's pretty impossible to derive the right body shape :/
                    .then(function (results) {
                        $log.warn('STUBSTUB: this just proves that the server is up. Does not actually have functionality.');
                        // push old state and transition
                        vm.previousState.push(id);
                        vm.previousState.push(currentState);
                        currentState = nextState;
                        // ok so here we already have to push the new available state, after flushing the array
                        vm.availableEvent = [];
                        specification.events.forEach(function (event) {
                            if (state_regex.exec(nextState)[1] === event_regex.exec(event.id)[1]) {
                                vm.availableEvent.push(event.id);
                            }
                        });

                        showSpec(currentState);
                    }, function (error) {
                        console.error("Error updating state", error);
                    });
            }

            // reset graph with click on init node
            inner.selectAll("g.node.initNode")
                .on("click", function (id) {
                    $log.debug("click init", id);
                    vm.reset();
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


    function transition() {
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
                $log.debug("Do something with modal result")
            }
        })
    }

}]);

app.controller('transitionCtrl', ['$scope', '$uibModalInstance', 'params',
    function ($scope, $uibModalInstance, params) {
        console.log("modal params: ", params);
        var tvm = this;
        tvm.params = params;
        tvm.close = function (result) {
            $uibModalInstance.close(result);
        }
    }]);
/**
 * Created by bc27wo on 05/12/2016.
 */