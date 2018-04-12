package br.com.projeto.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.projeto.model.Cliente;

@RestController
@RequestMapping("/products")
public class ProductOrderController {

	@RequestMapping(method = RequestMethod.GET)
	public List<Cliente> findClientes() {
		return new ArrayList<Cliente>();
	}
	
}
