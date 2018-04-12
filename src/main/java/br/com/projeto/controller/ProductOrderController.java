package br.com.projeto.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.projeto.form.ProductOrderForm;
import br.com.projeto.model.Cliente;
import br.com.projeto.model.ProductOrder;

@RestController
@RequestMapping("/products")
public class ProductOrderController {

	@RequestMapping(method = RequestMethod.GET)
	public List<Cliente> findClientes() {
		return new ArrayList<Cliente>();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ProductOrder create(@RequestBody ProductOrderForm productForm) {

		ProductOrder prdSaved = null;

		try {
			prdSaved = null;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return prdSaved;
	}
	
}
