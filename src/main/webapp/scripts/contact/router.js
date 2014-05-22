'use strict';

johnGShultzApp
    .config(['$routeProvider', '$httpProvider', '$translateProvider',
        function ($routeProvider, $httpProvider, $translateProvider) {
            $routeProvider
                .when('/contact', {
                    templateUrl: 'views/contacts.html',
                    controller: 'ContactController',
                    resolve:{
                        resolvedContact: ['Contact', function (Contact) {
                            return Contact.query();
                        }]
                    }
                })
        }]);
