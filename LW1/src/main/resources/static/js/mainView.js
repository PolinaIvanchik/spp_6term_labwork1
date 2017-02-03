/**
 * Created by Артем Константинович on 10.10.2016.
 */
var App = angular.module('mainView', []);

App.controller('AuthController',['$scope','$http', function ($scope, $http) {
    var vm = $scope;

    vm.registerUser = function () {
        if (getUserName()) {
            $http.post('http://localhost:8080/registration', getUserName()).then(function (response) {
                if (response.data === 200) {
                    window.location = "http://localhost:8080/blog.html";
                } else {
                    alert("user with this name already exist");
                }
            });
        } else {
            alert("Enter username");
        }
    };

    vm.login = function () {
        if (getUserName()) {
            $http.post('http://localhost:8080/login', getUserName()).then(function (response) {
                if(response.data === 200) {
                    window.location.href = "http://localhost:8080/blog.html";
                } else {
                    alert("we can't find user with this name");
                }
            });
        } else {
            alert("Enter username");
        }
    };

    function getUserName() {
        return document.getElementById("userName").value;
    }

}]);
