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

    it("should change location to userRegistered if success response", function () {
        $httpBackend.expectPOST('/register', {name: '', password: ''}).respond(201, '');
        scope.register();
        $httpBackend.flush();
        expect(location.path()).toBe("/userRegistered");
    });

    it("should set error status to true if internal server error returned", function () {
        $httpBackend.expectPOST('/register', {name: '', password: ''}).respond(500, '');
        scope.register();
        $httpBackend.flush();
        expect(scope.serverError).toBeTruthy();
    });

    it("should set is processing status during register processing", function() {
        $httpBackend.expectPOST('/register', {name: '', password: ''}).respond(500, '');
        scope.register();
        expect(scope.isProcessing).toBeTruthy();
        $httpBackend.flush();
        expect(scope.isProcessing).toBeFalsy();
    });
});