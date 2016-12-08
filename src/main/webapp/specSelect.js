/**
 * Created by bc27wo on 09/11/2016.
 */
'use strict';
var app = angular.module('visualApp.selection', []);

app.controller('specCtrl', ['$log', '$uibModal', '$http', '$window', '$scope', function ($log, $uibModal, $http, $window, $scope) {
    var vm = this;

    vm.showSpec = showSpec;
    vm.startSpec = startSpec;
    // vm.transition = transition;
    vm.apitest = apitest;
    vm.reset = reset;

    vm.currentState = undefined;
    vm.stateData = '';

    vm.interpolOptions = ["linear", "step", "basis", "bundle", "cardinal", "monotone"];
    vm.interpol = vm.interpolOptions[2];

    $http.get('states_hacked.json').then(function (results) {
        vm.specs = results.data;
        var keys = Object.keys(vm.specs.paths);
        vm.specNames = getSpecNames(keys);
        vm.specMap = getSpecMap(keys);
    });

    // maybe need a prefix for the api?
    var server = 'http://localhost:8080/';
    var apiPrefix = '';

    vm.machineId = '';
    vm.devmode = false;
    vm.staticSim = false;

    //default spec (so you don't have to pick one always)
    vm.selectedSpec = undefined;

    // initial size of graph (not relevant??)
    vm.h = $window.innerHeight;
    vm.w = $window.innerWidth;

    // track previous states to show progress
    vm.previousState = [];

    // placeholder text (I am still confused why the graph doesn't fill full width, but text does...)
    vm.lipsum = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Peccata paria. Sed ego in hoc resisto; Sed residamus, inquit, si placet. Cum praesertim illa perdiscere ludus esset. Duo Reges: constructio interrete. Sed ego in hoc resisto; In qua quid est boni praeter summam voluptatem, et eam sempiternam? At iam decimum annum in spelunca iacet.          Comprehensum, quod cognitum non habet? Murenam te accusante defenderem. Ut optime, secundum naturam affectum esse possit. Quae qui non vident, nihil umquam magnum ac cognitione dignum amaverunt. Etenim semper illud extra est, quod arte comprehenditur. Post enim Chrysippum eum non sane est disputatum. Tum Quintus: Est plane, Piso, ut dicis, inquit";

    function getUrl() {
        return server + apiPrefix + vm.selectedSpec + '/' + vm.machineId + '/';
    }

    function apitest() {
        $log.debug("GET from ", getUrl());
        $http.get(getUrl())
            .then(function (results) {
                $log.info("GET succes", results);
            }, function (error) {
                $log.warn("GET failed: ", error);
            });
    }

    function getSpecNames(keys) {
        // Two options: extract specname from key with regex, or look up the unique entries in the 'tags' field...
        // http://stackoverflow.com/questions/14061349/regular-expression-match-all-words-but-match-unique-words-only-once
        var rgx = /[,"\n]\/(\w+)\/(?!.*\1\b)/g;
        // this creates an array of matches. Unfortunately, these contain the delimiters as well...
        var matches = keys.toString().match(rgx);

        //replace not so useful characters
        for (var i = 0; i < matches.length; i++) {
            matches[i] = matches[i].replace(/[,\/]/g, "");
        }
        vm.selectedSpec = matches[0];
        return matches;
        // NOTE: REGEX might fail with multiple slashes in an endpoint, example string:
        // var str = '/OnUsCreditTransferNL/{id}/Create/test/longer/call';
    }

    function getSpecMap(keys) {
        // api calls are stored as keys (objects) in specs.paths
        // obtain array with api paths
        var spec_re = /\/(\w+)\//;
        var trans_re = /.*}\/(\w+)/;

        // mapmap approach
        var statemap = new Map();
        var specmap = new Map(statemap);

        keys.forEach(function (key) {
            if (key[key.length - 1] !== "}") {
                var spec = spec_re.exec(key)[1];
                var trans = trans_re.exec(key)[1];

                var stateObj = vm.specs.paths[key]["x-states"];
                // I am now going to assume that only the first is relevant (machine id),
                // the other is provided by the schema
                // stateObj.params = new Array(vm.specs.paths[key].post.parameters[0]);
                var ref = vm.specs.paths[key].post.parameters[1].schema["$ref"];
                var body = vm.specs[ref.split("/")[1]][ref.split("/")[2]];
                stateObj.params = body.properties[trans].properties;

                // ok this is an absolutely horrible way to get the data out
                // is there always only one required object,
                // and does it also coincide with the name of the corresponding Transition?

                // path: vm.specs.definitions.[ref_body].properties.[Transition].properties
                // var prop = body.properties[Object.keys(body.properties)[0]].properties;

                // var prop = body.properties[trans].properties;
                stateObj.trans = trans;

                if (specmap.has(spec)) {
                    specmap.set(spec, statemap.set(trans, stateObj));
                }
                else {
                    statemap = new Map();
                    specmap.set(spec, statemap.set(trans, stateObj));
                }
            }
        });
        $log.debug("mapmap: ", specmap);
        return specmap;
    }

    function reset() {
        vm.previousState = [];
        vm.availableEvent = [];
        vm.currentState = undefined;
        showSpec();
    }

    function getInit(map) {
        for (var value of map.values()) {
            if (value.initial) {
                return value.fromstate;
            }
        }
        throw new Error("No initial state found!");
    }

    function showSpec() {
        $log.debug("current state: ", vm.currentState);
        // TODO: remove map from here??
        var map = vm.specMap.get(vm.selectedSpec);
        var svg = d3.select("svg");

        if (vm.staticSim) {
            $log.debug("Static");
            if (vm.currentState === undefined){
                vm.currentState = getInit(map);
            }
            specRenderer(map, svg);
        }
        else {
            try {
                $http.get(getUrl())
                    .then(function (results) {
                        $log.debug("results.data: ", results.data);
                        var stateInfo = results.data;
                        vm.currentState = stateInfo.split("(")[1].split(",")[0];
                        vm.stateData = stateInfo.split("Data")[1];
                        $log.debug("currentState: ", vm.currentState);
                        specRenderer(map, svg);
                    }, function (error) {
                        throw new Error("Server error: ", error);
                    });
            } catch (e) {
                window.alert(e);
            }
        }
    }

    function startSpec() {
        updateState();
    }

    // HERE starts them evil spec renderer
    function specRenderer(map, svg) {
        renderSpecification(map, svg);

        // var Specification = function (fqn, name, documentation, modifier, inheritsFrom, extendedBy,
        //                               fields, events, states, transitions, externalMachines,
        //                               transitionsToExternalMachines, transitionsFromExternalMachines) {
        //     this.fqn = fqn;
        //     this.name = name;
        //     this.documentation = documentation;
        //     this.modifier = modifier;
        //     this.inheritsFrom = inheritsFrom;
        //     this.extendedBy = extendedBy;
        //     this.fields = fields;
        //     this.events = events;
        //     this.states = states;
        //     this.transitions = transitions;
        //     this.externalMachines = externalMachines;
        //     this.transitionsToExternalMachines = transitionsToExternalMachines;
        //     this.transitionsFromExternalMachines = transitionsFromExternalMachines
        // };

        function buildGraph() {
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
            // var groupLabel = "<em>" + specification.name + "</em>";
            var groupLabel = "<em>" + vm.selectedSpec + "</em>";
            // if ("name" in specification.inheritsFrom) {
            //     if (specification.inheritsFrom.url !== "?") {
            //         groupLabel += "<span class='inheritsFrom'>inherits from <a href='#" + specification.inheritsFrom.url + "'>" + specification.inheritsFrom.name + "</a></span>";
            //     } else {
            //         groupLabel += "<span class='inheritsFrom'>inherits from " + specification.inheritsFrom.name + "</span>";
            //     }
            // }


            // This is important for labelling and referencing - not for now.
            /*
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
             */

            g.setNode(groupId, {
                labelType: "html",
                clusterLabelPos: "top",
                clusterLabelColor: "#000",
                label: groupLabel,
                class: "groupLabel"
            });

            /*
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
             */

            var drawInit = function (state) {
                g.setNode(state, {
                    shape: "initial",
                    label: "",
                    class: "initNode"
                });
                g.setParent(state, groupId);
            };

            var drawFinal = function (state) {
                g.setNode(state, {
                    shape: "final",
                    label: "",
                    style: "fill: black"
                });
                if (state === vm.currentState) {
                    g.setNode(state, {
                        shape: "final",
                        label: "",
                        style: "fill: red"
                    })
                }
                g.setParent(state, groupId);
            };

            var drawState = function (state) {
                // ok so you can draw them as shape circle (and they get the radius from the label size)
                // or you can do it as the initial/final state drawing... but then they won't have labels :/
                g.setNode(state, {
                    shape: "circle",
                    label: state,
                    class: "stateNode"
                });
                if (state === vm.currentState) {
                    g.setNode(state, {
                        shape: "circle",
                        class: "currentNode",
                        label: state
                    })
                }
                else if (vm.previousState.indexOf(state) > -1) {
                    g.setNode(state, {
                        shape: "circle",
                        class: "previousNode",
                        label: state
                    })
                }
                g.setParent(state, groupId);
            };

            var drawEvent = function (event) {
                // this one is different from the rest because we create it with EVENT not with EVENT.FROM/TOSTATE
                var transition = event.trans;

                // NOTE: Some edges can be previous AND available (e.g. deposit, withdraw...)
                if (vm.previousState.indexOf(transition) > -1) {
                    g.setNode(transition, {
                        shape: "circle",
                        class: "previousEdge",
                        label: transition,
                        // doc: "doc" in event ? event.doc : "",
                        // config: "config" in event ? event.config : [],
                        params: event.params,
                        // preconditions: "preconditions" in event ? event.preconditions : [],
                        // postconditions: "postconditions" in event ? event.postconditions : [],
                        // sync: "sync" in event ? event.sync : []
                    })
                }
                else if (event.fromstate === vm.currentState) {
                    g.setNode(transition, {
                        shape: "circle",
                        class: "availableEdge",
                        label: transition,
                        // doc: "doc" in event ? event.doc : "",
                        // config: "config" in event ? event.config : [],
                        params: event.params,
                        // preconditions: "preconditions" in event ? event.preconditions : [],
                        // postconditions: "postconditions" in event ? event.postconditions : [],
                        // sync: "sync" in event ? event.sync : []
                    });
                }
                else {
                    g.setNode(transition, {
                        shape: "circle",
                        class: "unavailableEdge",
                        label: transition,
                        // doc: "doc" in event ? event.doc : "",
                        // config: "config" in event ? event.config : [],
                        params: event.params,
                        // preconditions: "preconditions" in event ? event.preconditions : [],
                        // postconditions: "postconditions" in event ? event.postconditions : [],
                        // sync: "sync" in event ? event.sync : []
                    });
                }
                g.setParent(transition, groupId);
            };

            // Set up internal edges
            var drawEdge = function (trans) {
                // TODO: drawEdge(param) trans.from becomes param.fromstate, etc
                if (vm.previousState.indexOf(trans.via) > -1) {
                    g.setEdge(trans.from, trans.via, {
                        arrowhead: "undirected",
                        lineInterpolate: vm.interpol,
                        class: "previous"
                    });
                    g.setEdge(trans.via, trans.to, {
                        lineInterpolate: vm.interpol,
                        class: "previous",
                    });
                }
                else {
                    g.setEdge(trans.from, trans.via, {
                        label: "",
                        arrowhead: "undirected",
                        lineInterpolate: vm.interpol
                    });
                    g.setEdge(trans.via, trans.to, {label: "", lineInterpolate: vm.interpol});
                }
            };
            map.forEach(function (value, key) {
                // visualisation is slightly different if you put drawEvent in if-tree
                drawEvent(value);

                var fromExists = g._nodes.hasOwnProperty(value.fromstate);
                var toExists = g._nodes.hasOwnProperty(value.tostate);

                if (!fromExists) {
                    if (value.initial) {
                        drawInit(value.fromstate);
                    }
                    else {
                        drawState(value.fromstate);
                    }
                }
                if (!toExists) {
                    if (value.final) {
                        drawFinal(value.tostate);
                    }
                    else {
                        drawState(value.tostate);
                    }
                }
                // TODO: change fromviato to drawEdge(value)
                drawEdge({from: value.fromstate, via: value.trans, to: value.tostate})
            });


            /*
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


             // set up external edges
             specification.transitionsToExternalMachines.forEach(function (trans) {
             g.setEdge(trans.from, trans.to, {class: "syncTo", lineInterpolate: "basis"});
             });

             specification.transitionsFromExternalMachines.forEach(function (trans) {
             g.setEdge(trans.fromMachine, trans.to, {class: "syncFrom", lineInterpolate: "basis"});
             });
             */

            return g;
        }

        function renderSpecification(map, svgDomElement) {
            var g = buildGraph();

            svgDomElement.select("g").remove();
            svgDomElement.insert("g");

            var inner = svgDomElement.select("g");

            // Set up zoom support
            // var zoom = d3.behavior.zoom().on("zoom", function () {
            //     inner.attr("transform", "translate(" + d3.event.translate + ")" +
            //         "scale(" + d3.event.scale + ")");
            // });
            // svgDomElement.call(zoom);

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
                // this is basically the tooltip title
                // var content = edgeNode.doc !== "" ? "<h2>" + edgeNode.doc + "</h2>" : "";
                var content = "<h2>" + edgeNode.label + "</h2>";

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

                var items = [];
                items.push("<thead><th>Parameter</th></thead>");
                for (var param in edgeNode.params) {
                    items.push("<tr><td>" + param + "</td></tr>");
                }
                content += createPart("Transition parameters", items);
                // content += edgeNode.preconditions.length > 0 ? createPart("Preconditions", preprocessStatements(edgeNode.preconditions)) : "";
                // content += edgeNode.postconditions.length > 0 ? createPart("Postconditions", preprocessStatements(edgeNode.postconditions)) : "";
                // content += edgeNode.sync.length > 0 ? createPart("Synchronized events", preprocessStatements(edgeNode.sync)) : "";
                return content;
            };
            render(inner, g);
            // tooltips
            inner.selectAll("g.node.availableEdge, g.node.previousEdge, g.node.unavailableEdge")
                .filter(function (trans) {
                    return map.get(trans).params !== undefined;
                })
                .attr("title", function (trans) {
                    return styleTooltip(g.node(trans));
                })
                .each(function (v) {
                    $(this).tipsy({gravity: "w", opacity: 0.8, html: true});
                });

            // select only available events
            inner.selectAll("g.node.availableEdge, g.node.previousEdge")
                .filter(function (trans) {
                    return map.get(trans).fromstate === vm.currentState;
                })
                // TODO: ng 'start action' should trigger this event also
                .on("click", function (trans) {
                    updateState(trans);
                });

            function getBody(trans, callback) {
                if (map.get(trans).params !== undefined) {
                    $log.info("Parameters needed");
                    // $log.debug("Params: ", g.node(trans).params);
                    vm.params = g.node(trans).params;
                    var $uibModalInstance = $uibModal.open({
                        animation: true,
                        templateUrl: 'partials/transitionForm.tpl.html',
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
                            $log.debug({[trans]: {results}});
                            callback({[trans]: results});
                        }
                        else {
                            $log.debug("No results");
                        }
                    }, function (error) {
                        console.error("error: ", error);
                    });
                    $log.debug("End if")
                }
                else {
                    console.debug("No params needed");
                    callback({[trans]: {}});
                }
            }

            function updateState(trans) {
                $log.debug("I'm going to update state");
                var stateObj = map.get(trans);

                if (vm.staticSim) {
                    vm.previousState.push(stateObj.fromstate);
                    vm.previousState.push(trans);
                    $log.debug("static: ", vm.previousState);
                    vm.currentState = stateObj.tostate;
                    showSpec();
                }
                else {
                    getBody(trans, function(body) {
                    $log.debug("POST body: ", body);
                    // TODO: do the actual post
                    $http.post(getUrl() + trans, body)
                        .then(function (results) {
                            $log.debug(results.data);

                            vm.previousState.push(stateObj.fromstate);
                            vm.previousState.push(trans);

                            // TODO REVIEW: get state from http response instead of from 'tostate'
                            vm.currentState = results.data.split("(")[1].split("(")[0];
                            showSpec();
                        }, function (error) {
                            // $log.error("Error updating state", error);
                            $log.error("Response text: ", error.responseText);
                        });
                    });
                }
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
        }

        return {
            // Specification: Specification,
            // currentState: vm.currentState,
            render: renderSpecification
        }
    }


    function transition() {
        var $uibModalInstance = $uibModal.open({
            animation: true,
            templateUrl: 'partials/transitionForm.tpl.html',
            controller: 'transitionCtrl',
            controllerAs: 'tvm',
            resolve: {
                params: function () {
                    return vm.params;
                }
            }
        });
        // TODO: below code seems not reached
        $uibModalInstance.result.then(function (results) {
            $log.debug("DOES NOT REACH//not relevant?");
            if (results) {
                $log.debug("Modal close: ", results);
            }
        })
    }

}]);

app.controller('transitionCtrl', ['$scope', '$uibModalInstance', '$log', 'params',
    function ($scope, $uibModalInstance, $log, params) {
        // $log.debug("modal params: ", params);
        var tvm = this;
        //TODO: Where to get currencies from?
        tvm.params = params;
        $scope.output = {};
        $scope.currentTime = new Date().getTime();
        tvm.close = function (data) {
            $uibModalInstance.close(data);
        }
    }]);
