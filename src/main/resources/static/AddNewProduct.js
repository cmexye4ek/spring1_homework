angular.module('addNewProductApp', []).controller('addNewProductController', function($scope, $http) {

 $scope.newProductPost = function (product) {
  $scope.product = {}
   $http.post('http://localhost:8189/app/products/add_new', product).then(function (response) {
   });
 };
});