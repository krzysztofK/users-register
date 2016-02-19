(function (angular) {
    angular.module("usersRegister.controllers", []);
    var usersRegister = angular.module("usersRegister", ["ngRoute", "usersRegister.controllers"]);
    usersRegister.config(['$routeProvider',
        function($routeProvider) {
            $routeProvider.
            when('/register', {
                templateUrl: 'partials/registerUser.html',
                controller: 'UsersRegisterController'
            }).
            when('/userRegistered', {
                templateUrl: 'partials/userRegistered.html',
                controller: 'UserRegisteredController'
            }).
            otherwise({
                redirectTo: '/register'
            });
        }]);
}(angular));