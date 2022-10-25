var app = angular.module('app', ['ui.router']);

app.config(['$stateProvider', '$urlRouterProvider', function($stateProvider, $urlRouterProvider){
    $stateProvider
    .state('calc', {
        url: "/calc",
        templateUrl: 'calc.html',
        controller: 'calcCtrl'
    })
    .state('add', {
        url: '/add?a&b',
        templateUrl: 'result.html',
        controller: 'addCtrl',
        data: {
            multiplier: 10
        }
    })
    .state('root', {
        url: '/',
        template: '<strong>you are at root... click something else</strong>'
    })

    $urlRouterProvider.otherwise('/');
}]);


app.controller('calcCtrl', ['$scope', '$state',function($scope, $state) {
    $scope.a = 0;
    $scope.b = 0;

    $scope.doAdd = function(){
        $state.go('add', {
            a: $scope.a,
            b: $scope.b
        })
    }
}])

app.controller('addCtrl', ['$scope', '$stateParams', '$state', function($scope, $stateParams, $state) {
    
    $scope.a = 0;
    $scope.b = 0;
    
    if($stateParams.a){
        $scope.a = $stateParams.a;
    }

    if($stateParams.b){
        $scope.b = $stateParams.b;
    }
    
    $scope.result = (parseInt($scope.a) + parseInt($scope.b)) 
                        * $state.current.data.multiplier;

    $scope.goBack = function(){
        $state.go('calc');
    }
}])