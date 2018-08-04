
angular.module("cart", [])
    .factory("cart", function () {
        let cartData = [];

        return {
            addItem: (id, name, price) => {
                let existing = false;
                for(let i=0; i<cartData.length; i++) {
                    if(cartData[i].id === id) {
                        existing = true;
                        cartData[i].count++;
                        break;
                    }
                }
                if(!existing) {
                    cartData.push({ count: 1, name: name, price: price, id: id })
                }
            },
            removeItem: (id) => {
                for(let i=0; i<cartData.length; i++) {
                    if(cartData[i].id === id)
                        cartData.splice(i, 1);
                }
            },
            getItems: () => cartData
        }
    })
    .directive("cartSummary", function (cart) {
        return {
            restrict: "E",
            templateUrl: "views/cart/cartSummary.html",
            controller: function ($scope) {
                let cartData = cart.getItems();

                $scope.total = () => {
                    let total = 0;
                    cartData.forEach(item => total+=item.price * item.count);
                    return total;
                };
                $scope.count = () => {
                    let total = 0;
                    cartData.forEach(item => total+=item.count);
                    return total;
                };
            }
        }
    });