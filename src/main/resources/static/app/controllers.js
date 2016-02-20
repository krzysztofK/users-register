(function (angular) {
    var UsersRegisterController = function ($scope, $http, $location, $rootScope) {
        $scope.user = {name: '', password: ''};
        $scope.register = function () {
            $http.post('/register', $scope.user).then(function (response) {
                $rootScope.user = $scope.user;
                $location.path("/userRegistered")
            }, function (response) {
                if (response.status === 409) {
                    $scope.registerUserForm.userName.$setValidity("notUnique", false);
                    $scope.registerUserForm.$setUntouched();
                }
            });
        };
        $scope.resetNotUnique = function () {
            $scope.registerUserForm.userName.$setValidity("notUnique", true);
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