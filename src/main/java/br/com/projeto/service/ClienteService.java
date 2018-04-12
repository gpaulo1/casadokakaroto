package br.com.projeto.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.projeto.model.Cliente;
import br.com.projeto.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	ClienteRepository _clienteRepository;

	private Cliente _contaCliente = null;

	/**
	 * Método para validar saldo e realizar o saque
	 * 
	 * @param cliente
	 * @param quantiaSaque
	 * @return
	 */
	public List<String> gerarSaque(Integer clienteId, double quantiaSaque) {

		List<String> valores = new ArrayList<String>();

		if (validarSaldo(clienteId, quantiaSaque)) {

			final double nota100 = 100.00;
			final double nota50 = 50.00;
			final double nota20 = 20.00;
			final double nota10 = 10.00;
			double valorRestanteSaque = quantiaSaque;

			do {
				if (nota100 <= valorRestanteSaque) {
					valorRestanteSaque -= nota100;
					valores.add("R$ 100,00");
				} else if (nota50 <= valorRestanteSaque) {
					valorRestanteSaque -= nota50;
					valores.add("R$ 50,00");
				} else if (nota20 <= valorRestanteSaque) {
					valorRestanteSaque -= nota20;
					valores.add("R$ 20,00");
				} else if(nota10 == valorRestanteSaque){
					valorRestanteSaque -= nota10;
					valores.add("R$ 10,00");
				} else {
					valores.add("Valor restante inválido!");
				}
			} while (valorRestanteSaque != 0);

			realizarDebito(clienteId, quantiaSaque);
			return valores;
		}

		valores.add("Saldo insuficiente.");
		return valores;
	}

	/**
	 * Debitar valor solicitado pelo cliente
	 * 
	 * @param cliente
	 * @param quantiaSaque
	 */
	public void realizarDebito(Integer clienteId, double quantiaSaque) {
		_contaCliente.setDebitarValor(quantiaSaque);
		_clienteRepository.saveAndFlush(_contaCliente);
	}

	/**
	 * Verificar se o cliente tem saldo disponível
	 * 
	 * @param cliente
	 * @param quantiaSaque
	 * @return
	 */
	public boolean validarSaldo(Integer clienteId, double quantiaSaque) {
		_contaCliente = _clienteRepository.findOne(clienteId);

		if (_contaCliente.getSaldo() >= quantiaSaque) {
			return true;
		}

		return false;

	}
}
