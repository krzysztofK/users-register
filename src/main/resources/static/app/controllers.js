(function (angular) {
    var UsersRegisterController = function ($scope, $http, $location, $rootScope) {
        $scope.user = {name: '', password: ''};
        $scope.register = function () {
            console.log($scope.user);
            $http.post('/register', $scope.user).then(function (response) {
                console.log("sukces");
                $rootScope.user = $scope.user;
                $location.path("/userRegistered")
            }, function (response) {
                console.log("kicha");
            });
        };
    };
    var UserRegisteredController = function ($scope) {
    };
    UsersRegisterController.$inject = ['$scope', '$http', '$location', '$rootScope'];
    UserRegisteredController.$inject = ['$scope'];
    var module = angular.module("usersRegister.controllers");
    module.controller("UsersRegisterController", UsersRegisterController);
    module.controller("UserRegisteredController", UserRegisteredController);
}(angular));