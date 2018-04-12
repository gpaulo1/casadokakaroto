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
		
		/**
		 * Set pictures to related object
		 */
		$scope.fileSelected = function(elements) {
			$scope.pictures = elements.files;
		}
		
		/**
		 * Save new one product at data base
		 */
		$scope.saveProduct = function() {

			$scope.productCopy = angular.copy($scope.mdAddProduct);
			$scope.productCopy.orderDate = "10/10/2018";
			
			Product.query(function(response) {
				$scope.clientes.saqueRealizado = response;
			});

			if (!$scope.isSaveProductFieldsValid()) {
				return;
			}

		}
		
		/**
		 * Check if save product form has valid fields before send the object
		 */
		$scope.isSaveProductFieldsValid = function() {

			var isValid = true;

			// Description
			if ($scope.mdAddProduct.description == "") {
				isValid = false;
				alertify.error("Campo 'Descrição' inválido.");
			}

			// Quantity
			if ($scope.mdAddProduct.quantity < 0) {
				isValid = false;
				alertify.error("Campo 'Quantidade' inválido.");
			}

			// Price
			var priceFormatted = $scope.mdAddProduct.price.substr(5);
			if (priceFormatted < 0.00) {
				isValid = false;
				alertify.error("Campo 'Valor de Compra' inválido.");
			} else {
				$scope.productCopy.price = priceFormatted;
			}

			// Order date
			if (!moment($scope.ordertDate).isValid()) {
				isValid = false;
				alertify.error("Campo 'Data da Compra' inválido.");
			}

			// Dollar value
			var dollarPriceFormatted = $scope.mdAddProduct.dollarPrice
					.substr(5);
			if (dollarPriceFormatted < 0.00) {
				isValid = false;
				alertify.error("Campo 'Valor do Dólar' inválido.");
			} else {
				$scope.productCopy.dollarPrice = dollarPriceFormatted;
			}

			// Shipping price
			var shippingPriceFormatted = $scope.mdAddProduct.shippingCost
					.substr(5);
			if (shippingPriceFormatted < 0.00) {
				isValid = false;
				alertify.error("Campo 'Valor do Frete' inválido.");
			} else {
				$scope.productCopy.shippingCost = shippingPriceFormatted;
			}

			return isValid;
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