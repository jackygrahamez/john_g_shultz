'use strict';

johnGShultzApp.factory('Resume', ['$resource',
    function ($resource) {
        return $resource('app/rest/resumes/:id', {}, {
            'query': { method: 'GET', isArray: true},
            'get': { method: 'GET'}
        });
    }]);
