angular.module('productList', []).controller('productListController', function($scope, $http) {
   $http.get('http://localhost:8189/app/products/list_all').then(function(response) {
     $scope.products = response.data;
   });
});
