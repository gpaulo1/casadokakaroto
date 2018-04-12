(function(angular) {
  var ProductOrderFactory = function($resource) {
    return $resource('/products', {
      id: '@id',
      valor: '@valor',
    }, {
      update: {
        method: "GET"
      },
      remove: {
        method: "DELETE"
      },
      realizarSaque: {
    	  method: "GET"
      }
    });
  };
  ProductOrderFactory.$inject = ['$resource'];
  angular.module("myApp.services").factory("ProductOrder", ProductOrderFactory);
}(angular));