/**
 * Created by Артем Константинович on 10.10.2016.
 */
var App = angular.module('mainView', []);

App.controller('mainCtrl',['$scope','$http', function ($scope, $http) {
    var vm = $scope;

    vm.registerUser = function (name) {
        $http.post('http://localhost:8080/registration', name).then(function () {
            window.location = "http://localhost:8080/blog";
        });
    };

    vm.registerUser = function (name) {
        $http.post('http://localhost:8080/login', name).then(function () {
            window.location = "http://localhost:8080/blog";
        }, function (response) {
            console.log(response);
        });
    };


}]);
