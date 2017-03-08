angular.module('ngBoilerplate.account', ['ui.router', 'ui.bootstrap', 'ngResource'])
    .config(function ($stateProvider) {
        $stateProvider.state('login', {
           url: '/login',
           views: {
               'main': {
                   templateUrl: 'account/login.tpl.html',
                   controller: 'LoginCtrl'
               }
           },
            data: { pageTitle: 'Login' }
        })
        .state('register', {
            url: '/register',
            views: {
                'main': {
                    templateUrl: 'account/register.tpl.html',
                    controller: 'RegisterCtrl'
                }
            },
            data: { pageTitle: 'Register' }
        })
        .state('user', {
            url: '/user',
            views: {
                'main': {
                    templateUrl: 'account/user.tpl.html'
                    //controller: 'UserCtrl'
                }
            }
            //data: {pageTitle: 'User'}
        });
    })
    .factory('sessionService', function () {
        var session = {};
        session.login = function (data) {
            alert('User logged in with ' + data.name);
            localStorage.setItem("session", data);
        };

        session.logout = function () {
          localStorage.removeItem("session");
        };

        session.isLoggedIn = function () {
            return localStorage.getItem("session") !== null;
        };

        return session;
    })
    .factory('accountService', function ($resource) {
        var service = {};
        service.register = function (account, success, failure) {
           var Account = $resource("/springapp/rest/accounts");
           Account.save({}, account, success, failure);
        };

        service.userExists = function (account, success, failure) {
            var Account = $resource("/springapp/rest/accounts");
            var data = Account.get({ name: account.name }, function () {
                var accounts = data.accounts;
                if(accounts.length !== 0) {
                    success(accounts[0]);
                } else {
                    failure();
                }
            },
                failure());
        };

        return service;
    })
    .controller('LoginCtrl', function ($scope, sessionService, $state, accountService) {
        $scope.login = function () {
            accountService.userExists($scope.account,
                function (account) {
                    sessionService.login(account);
                    $state.go("home");
                },
                function () {
                    alert("Error logging in user");
                });
            sessionService.login($scope.account);
            $state.go("home");
        };
    })
    .controller('RegisterCtrl', function ($scope, sessionService, $state, accountService) {
        $scope.register = function () {
            accountService.register($scope.account,
                function (returnedData) {
                    sessionService.login(returnedData);
                    $state.go("home");
                },
                function () {
                    alert("Error registering user");
                });
            sessionService.login($scope.account);
            $state.go("home");
        };
    });