(function(angular) {
  var ClienteFactory = function($resource) {
    return $resource('/clientes/:id/:valor', {
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