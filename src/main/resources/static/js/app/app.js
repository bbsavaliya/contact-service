var app = angular.module('crudApp',['ui.router','ngStorage']);

app.constant('urls', {
    BASE: 'http://localhost:8080/contact-service/',
    CONTACT_SERVICE_API : 'http://localhost:8080/contact-service/api/contact/'
});

app.config(['$stateProvider', '$urlRouterProvider',
    function($stateProvider, $urlRouterProvider) {

        $stateProvider
            .state('home', {
                url: '/',
                templateUrl: 'partials/list',
                controller:'ContactController',
                controllerAs:'ctrl',
                resolve: {
                    users: function ($q, ContactService) {
                        console.log('Load all contacts');
                        var deferred = $q.defer();
                        ContactService.loadAllContacts().then(deferred.resolve, deferred.resolve);
                        return deferred.promise;
                    }
                }
            });
        $urlRouterProvider.otherwise('/');
    }]);

