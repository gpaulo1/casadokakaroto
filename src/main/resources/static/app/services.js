(function(angular) {
  var ClienteFactory = function($resource) {
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
  ClienteFactory.$inject = ['$resource'];
  angular.module("myApp.services").factory("Cliente", ClienteFactory);
}(angular));