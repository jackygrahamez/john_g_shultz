'use strict';

johnGShultzApp
    .config(['$routeProvider', '$httpProvider', '$translateProvider',
        function ($routeProvider, $httpProvider, $translateProvider) {
            $routeProvider
                .when('/resume', {
                    templateUrl: 'views/resumes.html',
                    controller: 'ResumeController',
                    resolve:{
                        resolvedResume: ['Resume', function (Resume) {
                            return Resume.query();
                        }]
                    }
                })
        }]);
