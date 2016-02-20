describe('UsersRegisterController', function () {

    var scope, $httpBackend, location;

    beforeEach(module('usersRegister'));

    beforeEach(inject(function ($rootScope, $controller, $location, _$httpBackend_) {
        $httpBackend = _$httpBackend_;
        scope = $rootScope.$new();
        location = $location;
        $controller('UsersRegisterController', {$scope: scope});
    }));

    it("should initialize controller with empty user object", function () {
        expect(scope.user.name).toBe('');
        expect(scope.user.password).toBe('');
    });

    it("should set not unique name validation error if conflict response", function () {
        $httpBackend.expectPOST('/register', {name: '', password: ''}).respond(201, '');
        scope.register();
        $httpBackend.flush();
        expect(location.path()).toBe("/userRegistered");
    });
});