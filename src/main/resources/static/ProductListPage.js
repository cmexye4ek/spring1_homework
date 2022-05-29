angular.module('productList', []).controller('productListController', function($scope, $http) {
   $scope.getProductListPage = function () {
     $http.get('http://localhost:8189/app/products/list_all').then(function(response) {
       $scope.products = response.data;
     });
   };
   $scope.increaseCost = function (product) {
     $scope.product = {}
       $http.post('http://localhost:8189/app/products/increase_cost', product).then(function (response) {
       $scope.getProductListPage()
       });
   };
   $scope.decreaseCost = function (product) {
        $scope.product = {}
          $http.post('http://localhost:8189/app/products/decrease_cost', product).then(function (response) {
          $scope.getProductListPage()
          });
      };
});
