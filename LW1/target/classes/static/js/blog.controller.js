/**
 * Created by Артем on 29.01.2017.
 */
var App = angular.module('blog.controller', []);

App.controller('BlogController',['$scope','$http', function ($scope, $http) {
    var vm = $scope;
    vm.posts = [];
    vm.user = null;
    console.log(123);
    getPosts();

    $http.get('http://localhost:8080/user/current').then(function (response) {
        vm.user = response.data;
        console.log(response);
    });

    vm.addPost = function () {
        let post = {
            title:  document.getElementById("newPostTitle").value,
            text: document.getElementById("newPostBody").value,
            authorName: vm.user
        };
        if(vm.user) {
            $http.post('http://localhost:8080/add/post', post).then(function (response) {
                getPosts();
            });
        }
    };

    function getPosts() {
        $http.get('http://localhost:8080/get/post').then(function (response) {
            vm.posts = response.data;
            console.log(response);
        });
    }
}]);
