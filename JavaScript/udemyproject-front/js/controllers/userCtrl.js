angular.module("userCRUD").controller("userCtrl", function ($scope, $http) {
    $scope.users = [];
    $scope.user = {};

    $scope.registerUser = function (user) {
        $http.post("http://localhost:8080/users", user).then(function (data) {
            delete $scope.user;
            alert("Usuário registrado com sucesso!");
        })
    }

    var listUser = function () {
        $http.get("http://localhost:8080/users").then(function (response) {
            $scope.users = response.data;
        }).catch(function (data) {
            $scope.message = "Ocorreu um erro. Tente novamente."
        })
    }

    $scope.loadUser = function (user) {
        $scope.user = angular.copy(user);
    }

    $scope.updateUser = function (user) {
        $http.put(`http://localhost:8080/users/${user.id}`, user).then(function (data) {
            delete $scope.user;
            alert(`Usuário ${user.name} atualizado com sucesso!`)
            listUser();
        })
    }

    $scope.deleteUser = function (user) {
        $http.delete(`http://localhost:8080/users/${user.id}`).then(function (data) {
            alert(`Usuário ${user.name} deletado com sucesso!`)
            listUser();
        })
    }

    listUser();

})