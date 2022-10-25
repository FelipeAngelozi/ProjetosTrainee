var app = angular.module('app', ['ui.router']);

app.config(['$stateProvider', '$urlRouterProvider', function($stateProvider, $urlRouterProvider) {
    $stateProvider.state('firstMessage', {
        url: '/first-msg/{a}/{b}',
        templateUrl: 'message1.html',
        controller: 'message1'
    }).state('secondMessage', {
        url: '/second-msg/:c/:d',
        templateUrl: 'message2.html',
        controller: 'message2'
    }).state('thirdMessage', { //entra nesse se for um ou nenhum
        url: '/third-msg/{e}', //optional by default
        templateUrl: 'message3.html',
        controller: 'message3'
    }).state('thirdMessage2', { //entra se for dois
        url: '/third-msg/{e}/{f}', 
        templateUrl: 'message3.html',
        controller: 'message3'
    }).state('fourthMessage', {
        url: '/fourth-msg',
        templateUrl: 'message4.html',
        controller: 'message4',
        params: {
            g :{value: "100"},
            h :{value: "200"}
        }
    }).state('fifthMessage', { 
        url: '/fifth-msg?i&j',
        templateUrl: 'message5.html',
        controller: 'message5',
        params: {
            i :{value: "50"},
            j :{value: "150"}
        }
    })
    .state('root', {
        url: '/',
        template: '<strong> you are at root... click something else</strong>'
    });

    $urlRouterProvider.otherwise('/');
    
}]);

app.controller('message1', ['$scope', '$stateParams', function($scope, $stateParams){
    $scope.a = $stateParams.a;
    $scope.b = $stateParams.b;
}])

app.controller('message2', ['$scope', '$stateParams', function($scope, $stateParams){
    $scope.c = $stateParams.c;
    $scope.d = $stateParams.d;
}])

app.controller('message3', ['$scope', '$stateParams', function($scope, $stateParams){
    $scope.e = $stateParams.e;
    $scope.f = $stateParams.f;
}])

app.controller('message4', ['$scope', '$stateParams', function($scope, $stateParams){
    $scope.g = $stateParams.g;
    $scope.h = $stateParams.h;
}])

app.controller('message5', ['$scope', '$stateParams', function($scope, $stateParams){
    $scope.i = $stateParams.i;
    $scope.j = $stateParams.j;
}])