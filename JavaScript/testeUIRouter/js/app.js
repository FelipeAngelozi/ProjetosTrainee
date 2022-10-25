var app = angular.module('app', ['ui.router']);

app.config(['$stateProvider', '$urlRouterProvider', function($stateProvider) {
    $stateProvider.state('firstMessage', {
        url: '/first-msg',
        templateUrl: 'message1.html',
        controller: 'message1'
    }).state('secondMessage', {
        url: '/second-msg',
        templateUrl: 'message2.html',
        controller: 'message2'
    }).state('root', {
        url: '/',
        template: '<strong> you are at root... click something else</strong>'
    });

    $urlRouterProvider.otherwise('/');
    
}]);

app.controller('message1', ['$scope', function($scope){
    $scope.a = 10;
    $scope.b = 20;
}])

app.controller('message2', ['$scope', function($scope){
    $scope.c = 30;
    $scope.d = 40;
}])