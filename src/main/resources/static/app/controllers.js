(function(angular) {
	var AppController = function($scope, $http, Cliente) {
		$scope.clienteSaque;

		// init variables
		$scope.dollarVal = 'loading...';
		$scope.currentDate = moment().format('YYYY-MM-DD');
		$scope.mdAddProduct = "";
		$scope.productCopy = null;
		$scope.pictures = [];
		// Load mask money
		$("#mdPrice").maskMoney();
		$("#mdDollarValue").maskMoney();
		$("#mdShippingValue").maskMoney();
		
		Cliente.query(function(response) {
			$scope.clientes = response ? response : [];
		});
		
		/**
		 * Open modal to insert new product order
		 */
		$scope.modaladdProduct = function() {

			$scope.mdAddProduct = {
				description : '',
				quantity : 1,
				price : 'USD $0.00',
				orderDate : new Date($scope.currentDate),
				dollarPrice : 'USD $' + $scope.dollarVal,
				shippingType : 'Gratuito',
				shippingCost : 'USD $0.00'
			};

			$('#modalAddProduct').modal('toggle')
		}
		
		
		
		
		
		
		
		
		
		
		
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