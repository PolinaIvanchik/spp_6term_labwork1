/**
 * Created by Артем on 29.01.2017.
 */
var App = angular.module('blog.controller', []);

App.controller('BlogController',['$scope','$http','$location', function ($scope, $http) {
    var vm = $scope;
    vm.siteByCreation = [];

    $http.get('http://localhost:8080/site/sortedByCreate/' + $scope.maxByCreation).success(function (data) {
        vm.siteByCreation = data;
    });
    $http.get('http://localhost:8080/site/sortedByAlph/' + $scope.maxByAlph).success(function (data) {
        vm.siteByAlhp = data;
    });
    $http.get('http://localhost:8080/user/list/').success(function (data) {
        $scope.users = data;
    });
}]);
