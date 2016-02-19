(function (angular) {
    var UsersRegisterController = function ($scope) {
        $scope.user = {name: '', password: ''};
        $scope.register = function () {
            console.log($scope.user);
        };
    };
    UsersRegisterController.$inject = ['$scope'];
    angular.module("usersRegister.controllers").controller("UsersRegisterController", UsersRegisterController);
}(angular));