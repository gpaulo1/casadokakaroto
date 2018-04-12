(function(angular) {
	var AppController = function($scope, $http, Cliente) {
		$scope.clienteSaque;

		Cliente.query(function(response) {
			$scope.clientes = response ? response : [];
		});

		$scope.addCliente = function(cNome, cSaldo) {
			new Cliente({
				nome : cNome,
				saldo : cSaldo
			}).$save(function(cliente) {
				$scope.clientes.push(cliente);
			});
		};

		$scope.deleteCliente = function(cliente) {
			cliente.$remove(function() {
				$scope.clientes.splice($scope.clientes.indexOf(cliente), 1);
			});
		};

		$scope.selecionarClienteSaque = function(cliente) {
			$scope.clienteSaque = cliente;
		};

		$scope.realizarSaque = function(valor) {
			Cliente.query({
				id : $scope.clienteSaque.id,
				valor : valor
			}, function(response) {
				console.log(JSON.stringify(response));
				$scope.clientes.saqueRealizado = response;
			});
		};

		// Get dolalr value from rest call
		var onSuccess = function(data, status, headers, config) {
			$scope.dollarVal = data ? data[0].ask : [];
		};
		$http.get('https://economia.awesomeapi.com.br/json/USD-BRLT/1', {
			student : $scope.student
		}).success(onSuccess);

	};

	AppController.$inject = [ '$scope', '$http', 'Cliente' ];
	angular.module("myApp.controllers").controller("AppController",
			AppController);
}(angular));