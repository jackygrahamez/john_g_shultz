'use strict';

johnGShultzApp.factory('Fun_house', ['$resource',
    function ($resource) {
        return $resource('app/rest/fun_houses/:id', {}, {
            'query': { method: 'GET', isArray: true},
            'get': { method: 'GET'}
        });
    }]);
