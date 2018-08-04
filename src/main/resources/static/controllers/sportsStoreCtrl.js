
angular.module("sportsStore")
    .constant("productsUrl","http://localhost:8080/products")
    .controller("sportsStoreCtrl", function ($scope, $http, productsUrl) {
        $http.get(productsUrl)
            .then(
                (response) => {$scope.products = response.data; console.log($scope.products)},
                (error) => $scope.error = error);

    });