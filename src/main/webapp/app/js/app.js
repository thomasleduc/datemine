/* The main js file include by dependency in requireJS */

define(['angular'], ['angular', function (angular) {
    'use strict';
    
    var dateMineApp = angular.module('dateMineApp', []);
    
    dateMineApp.config(['$routeProvider', function($routeProvider) {
            $routeProvider
             .when('/home', {
                templateUrl: 'app/module/home/view/index.html',
                controller: 'homeCtrl'
             })
             .when('/video', {
                 templateUrl: 'app/module/main/view/index.html',
                 controller: 'mainCtrl'
             })
             .otherwise({
                 redirectTo:'/home'
             });
    }]);
}]);

