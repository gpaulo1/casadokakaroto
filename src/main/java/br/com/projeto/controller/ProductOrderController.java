package br.com.projeto.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.projeto.form.ProductOrderForm;
import br.com.projeto.model.Cliente;
import br.com.projeto.model.ProductOrder;
import br.com.projeto.service.ProductOrderService;

@RestController
@RequestMapping("/products")
public class ProductOrderController {

	@Autowired
	private ProductOrderService _prdService;

	@RequestMapping(method = RequestMethod.GET)
	public List<Cliente> findClientes() {
		return new ArrayList<Cliente>();
	}

	@RequestMapping(method = RequestMethod.POST)
	public ProductOrder create(@RequestBody ProductOrderForm productForm) {
		return _prdService.addProductOrder(productForm);
	}

}
