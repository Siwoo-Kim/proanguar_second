
angular.module("sportsStore")
    .controller("cartSummaryCtrl", function ($scope, cart) {

        $scope.items = cart.getItems();

        $scope.remove = (id) => cart.removeItem(id);
        $scope.total = () => {
            let total = 0;
            $scope.items.forEach(item => total+=item.price * item.count);
            return total;
        }
    })