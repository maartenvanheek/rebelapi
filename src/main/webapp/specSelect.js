/**
 * Created by bc27wo on 09/11/2016.
 */
'use strict';
var app = angular.module('visualApp.selection', []);

app.controller('specCtrl', ['$log', '$uibModal', '$http', '$window', function ($log, $uibModal, $http, $window) {
    var vm = this;
    vm.selectSpec = selectSpec;

    vm.showSpec = showSpec;
    vm.startSpec = startSpec;
    vm.transition = transition;
    vm.apitest = apitest;
    vm.reset = reset;

    // vm.specNames = undefined;

    // vm.specs = specs;
    $http.get('states_hacked.json').then(function (results) {
        vm.specs = results.data;
        // $log.debug("specs: ", vm.specs);
        // vm.processSpecs();
        var keys = Object.keys(vm.specs.paths);
        vm.specNames = getSpecNames(keys);
        vm.specMap = getSpecMap(keys);
        $log.debug(vm.specs);
    });

    // maybe need a prefix for the api?
    vm.server = 'http://localhost:8080/';
    vm.apiPrefix = '';
    vm.machineId = 1; //TODO: not sure yet where we get/store this id
    vm.specData = undefined; //TODO: this is meant to come from HTTP GET
    vm.devmode = true;

    //default spec (so you don't have to pick one always)
    vm.selectedSpec = undefined;

    vm.transitionId = undefined;

    // initial size of graph (not relevant??)
    vm.h = $window.innerHeight;
    vm.w = $window.innerWidth;

    // track previous states to show progress
    vm.previousState = [];
    vm.availableEvent = [];

    // placeholder text (I am still confused why the graph doesn't fill full width, but text does...)
    vm.lipsum = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Peccata paria. Sed ego in hoc resisto; Sed residamus, inquit, si placet. Cum praesertim illa perdiscere ludus esset. Duo Reges: constructio interrete. Sed ego in hoc resisto; In qua quid est boni praeter summam voluptatem, et eam sempiternam? At iam decimum annum in spelunca iacet.          Comprehensum, quod cognitum non habet? Murenam te accusante defenderem. Ut optime, secundum naturam affectum esse possit. Quae qui non vident, nihil umquam magnum ac cognitione dignum amaverunt. Etenim semper illud extra est, quod arte comprehenditur. Post enim Chrysippum eum non sane est disputatum. Tum Quintus: Est plane, Piso, ut dicis, inquit";

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

    function getSpecNames(keys) {
        // Two options: extrac specname from key with regex, or look up the unique entries in the 'tags' field...
        // http://stackoverflow.com/questions/14061349/regular-expression-match-all-words-but-match-unique-words-only-once
        var rgx = /[,"\n]\/(\w+)\/(?!.*\1\b)/g;
        // this creates an array of matches. Unfortunately, these contain the delimiters as well...
        var matches = keys.toString().match(rgx);

        //replace not so useful characters
        for (var i = 0; i < matches.length; i++) {
            matches[i] = matches[i].replace(/[,\/]/g, "");
        }
        return matches;
        // NOTE: REGEX might fail with multiple slashes in an endpoint, example string:
        // var str = '/IngNLAccount/{id}/Deposit,/IngNLAccount/{id}/Open,/OnUsCreditTransferNL/{id},/OnUsCreditTransferNL/{id}/Create/test/longer/call';
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
                stateObj.params = vm.specs.paths[key].post.parameters;
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

    function selectSpec() {
        // after selection of a specification, we have to parse the specs to find the right states
        var map = vm.specMap.get(vm.selectedSpec);
        showSpec(map, undefined);
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

    function getInit(map){
        for (var value of map.values()) {
            if (value.initial) {
                return value.fromstate;
            }
        }
        throw new Error("No initial state found!");
    }

    function showSpec(map, currentState) {
        if (currentState === undefined) {
            try {
                currentState = getInit(map);
            } catch (e){
                window.alert(e);
            }
        }
        $log.debug("currentState: ", currentState);
        var svg = d3.select("svg");
        // specRenderer.buildGraph(vm.selectedSpec,currentState);
        // specRenderer.renderSpecification(vm.selectedSpec, currentState, svg);
        specRenderer(map, currentState, svg);
    }

    function startSpec() {
        // this should fire the initial spec
    }

    // HERE starts them evil spec renderer
    function specRenderer(map, currentState, svg) {
        renderSpecification(map, currentState, svg);

        var state_regex = /state_([a-zA-Z]+)/;
        var event_regex = /event_([a-zA-Z]+)_([a-zA-Z]+)_([a-zA-Z]+)/;
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

        // var currentState = function (currentState) {
        //     this.currentState = currentState;
        // };

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
                if (state === currentState) {
                    g.setNode(state, {
                        shape: "final",
                        label: "",
                        style: "fill: red"
                    })
                }
                g.setParent(state, groupId);
            };

            var drawState = function (state) {
                $log.debug("State: ", state);
                // THIS IS DRAWN MULTIPLE TIMES (for each Event it loops all connected States)

                // ok so you can draw them as shape circle (and they get the radius from the label size)
                // or you can do it as the initial/final state drawing... but then they won't have labels :/
                g.setNode(state, {
                    shape: "circle",
                    // bbox: "width: 500, height: 500",
                    label: state,
                    class: "stateNode"
                });
                if (state === currentState) {
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
                // $log.debug("currentState: ", currentState);
                // $log.debug("event: ", event.trans);
                var transition = event.trans;

                if (vm.previousState.indexOf(event) > -1) {
                    $log.debug("Yay! previousState");
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
                else if (event.fromstate === currentState) {
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
            };
            map.forEach(function (value, key) {
                // visualisation is slightly different if you put drawEvent in if-tree
                $log.debug("transition, value: ", transition, value);
                drawEvent(value);
                if (value.initial) {
                    drawInit(value.fromstate);
                    drawState(value.tostate);
                }
                else if (value.final) {
                    drawState(value.fromstate);
                    drawFinal(value.tostate);
                }
                else {
                    drawState(value.fromstate);
                    drawState(value.tostate);
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

        function renderSpecification(specification, currentState, svgDomElement) {
            var g = buildGraph(specification, currentState);

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
                $log.debug("edgeNode: ", edgeNode);
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

                if (edgeNode.params.length > 0) {
                    $log.debug(edgeNode.params);
                    var items = [];
                    items.push("<thead><th>Parameter</th><th>Type</th></thead>");
                    edgeNode.params.forEach(function (p) {
                        // p.type may be undefined --> use description in that case?
                        items.push("<tr><td>" + p.name + "</td><td>" + p.type + "</td></tr>");
                    });
                    content += createPart("Transition parameters", items);
                }
                // content += edgeNode.preconditions.length > 0 ? createPart("Preconditions", preprocessStatements(edgeNode.preconditions)) : "";
                // content += edgeNode.postconditions.length > 0 ? createPart("Postconditions", preprocessStatements(edgeNode.postconditions)) : "";
                // content += edgeNode.sync.length > 0 ? createPart("Synchronized events", preprocessStatements(edgeNode.sync)) : "";
                return content;
            };
            $log.debug(g);
            render(inner, g);
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
                        $log.error("Error updating state", error);
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
        }

        return {
            // Specification: Specification,
            currentState: currentState,
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
        $uibModalInstance.result.then(function (results) {
            if (results) {
                $log.debug("Do something with modal result")
            }
        })
    }

}]);

app.controller('transitionCtrl', ['$scope', '$uibModalInstance', '$log', 'params',
    function ($scope, $uibModalInstance, $log, params) {
        $log.debug("modal params: ", params);
        var tvm = this;
        //TODO: Where to get currencies from?
        tvm.currencies = ["USD", "EUR"];
        tvm.selectedCurrency = tvm.currencies[1];
        tvm.params = params;

        $scope.money = {
            currency: "EUR",
            value: 0
        };


        $scope.$watchCollection('money', function updateMoney(money) {
            $log.debug("update money");
            var moneystr = money.currency + " " + money.value;
            $log.debug(moneystr);
            tvm.params.amount = moneystr;
        });


        tvm.close = function (data) {
            // replace money string

            $uibModalInstance.close(data);
        }
    }]);
