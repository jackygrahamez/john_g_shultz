'use strict';

johnGShultzApp
    .config(['$routeProvider', '$httpProvider', '$translateProvider',
        function ($routeProvider, $httpProvider, $translateProvider) {
            $routeProvider
                .when('/fun_house', {
                    templateUrl: 'views/fun_houses.html',
                    controller: 'Fun_houseController',
                    resolve:{
                        resolvedFun_house: ['Fun_house', function (Fun_house) {
                            return Fun_house.query();
                        }]
                    }
                })
        }]);
