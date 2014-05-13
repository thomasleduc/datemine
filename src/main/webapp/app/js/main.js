/* RequireJs Main File */

require.config({
	paths: {
		'angular': '../../bower_components/angular/angular',
                'angular-route': '../../bower_components/angular-route/angular-route',
		'ui.bootstrap': '../../bower_components/angular-bootstrap/ui-bootstrap-tpls'
	},
	baseUrl: 'app/js',
	shim: {
            'angular' : {'exports' : 'angular'},
            'angular-route': ['angular'],
            'ui.boostrap': ['angular']
	},
	priority: [
            "angular"
	]
});

//http://code.angularjs.org/1.2.1/docs/guide/bootstrap#overview_deferred-bootstrap
window.name = "NG_DEFER_BOOTSTRAP!";

require(
    [
    'angular',
    'app'
    ],
    ['angular', 'app', function(angular, app) {
        'use strict';
        var $html = angular.element(document.getElementsByTagName('html')[0]);

        angular.element().ready(function() {
            angular.bootstrap([app['name']]);
        });
    }]
);

