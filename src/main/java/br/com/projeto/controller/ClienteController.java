package br.com.projeto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.projeto.model.Cliente;
import br.com.projeto.repository.ClienteRepository;
import br.com.projeto.service.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired
	private ClienteRepository _clienteRepository;
	
	@Autowired
	private ClienteService _clienteService;

	@RequestMapping(method = RequestMethod.GET)
	public List<Cliente> findClientes() {
		return _clienteRepository.findAll();
	}

	@RequestMapping(method = RequestMethod.POST)
	public Cliente addCliente(@RequestBody Cliente cliente) {
		return _clienteRepository.saveAndFlush(cliente);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void deleteCliente(@PathVariable Integer id) {
		_clienteRepository.delete(id);
	}

	@RequestMapping(value = "/{id}/{valorSaque}", method = RequestMethod.GET)
	public List<String> realizarSaque(@PathVariable Integer id, @PathVariable double valorSaque) {
		return _clienteService.gerarSaque(id, valorSaque);
	}
	
}
