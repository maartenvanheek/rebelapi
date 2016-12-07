/**
 * Created by bc27wo on 09/11/2016.
 */
'use strict';
var app = angular.module('visualApp', [
    'ui.bootstrap',
    'ui.router',
    'visualApp.selection'
]);


app.config(['$urlRouterProvider', function ($urlRouterProvider) {
    $urlRouterProvider.otherwise("/");
}]);
//
// app.config(function($stateProvider){
//     $stateProvider
//         .state('selection',{
//             url: '/',
//             templateUrl: 'transaction.html',
//             controller: 'transactionCtrl',
//             // controllerAs: 'tvm'
//         })
// });

app.config(function ($logProvider) {
    // show/hide debug logs
    $logProvider.debugEnabled(true);
});
//
app.run(['$http', function($http){
    // $http.defaults.headers.post.Access-Control-Allow-Origin = '*';
    $http.defaults.headers.post['Access-Control-Allow-Origin'] = 'somewhere';
}]);
