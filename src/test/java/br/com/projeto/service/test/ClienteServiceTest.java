package br.com.projeto.service.test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import br.com.projeto.service.ClienteService;

@RunWith(MockitoJUnitRunner.class)
public class ClienteServiceTest {

	private final Double VALOR_10 = 10.00;
	private final Double VALOR_20 = 20.00;
	private final Double VALOR_50 = 50.00;
	private final Double VALOR_70 = 70.00;
	private final Double VALOR_90 = 90.00;
	private final Double VALOR_530 = 530.00;
	private final Integer CLIENTE_ID = 1;

	@Mock
	ClienteService clienteService;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	/**
	 * Realizar saque no valor de R$10,00
	 */
	@Test
	public void gerarSaqueValor10ReaisTest() {
		when(clienteService.validarSaldo(CLIENTE_ID, VALOR_10)).thenReturn(true);
		when(clienteService.gerarSaque(CLIENTE_ID, VALOR_10)).thenCallRealMethod();

		List<String> resultado = clienteService.gerarSaque(CLIENTE_ID, VALOR_10);
		assertEquals(resultado.get(0), "R$ 10,00");
	}

	/**
	 * Realizar saque no valor de R$20,00
	 */
	@Test
	public void gerarSaqueValor20ReaisTest() {
		when(clienteService.validarSaldo(CLIENTE_ID, VALOR_20)).thenReturn(true);
		when(clienteService.gerarSaque(CLIENTE_ID, VALOR_20)).thenCallRealMethod();

		List<String> resultado = clienteService.gerarSaque(CLIENTE_ID, VALOR_20);
		assertEquals(resultado.get(0), "R$ 20,00");
	}

	/**
	 * Realizar saque no valor de R$50,00
	 */
	@Test
	public void gerarSaqueValor50ReaisTest() {
		when(clienteService.validarSaldo(CLIENTE_ID, VALOR_50)).thenReturn(true);
		when(clienteService.gerarSaque(CLIENTE_ID, VALOR_50)).thenCallRealMethod();

		List<String> resultado = clienteService.gerarSaque(CLIENTE_ID, VALOR_50);
		assertEquals(resultado.get(0), "R$ 50,00");
	}

	/**
	 * Realizar saque no valor de R$70,00
	 */
	@Test
	public void gerarSaqueValor70ReaisTest() {
		when(clienteService.validarSaldo(CLIENTE_ID, VALOR_70)).thenReturn(true);
		when(clienteService.gerarSaque(CLIENTE_ID, VALOR_70)).thenCallRealMethod();

		List<String> resultado = clienteService.gerarSaque(CLIENTE_ID, VALOR_70);
		assertEquals(resultado.get(0), "R$ 50,00");
		assertEquals(resultado.get(1), "R$ 20,00");
	}

	/**
	 * Realizar saque no valor de R$90,00
	 */
	@Test
	public void gerarSaqueValor90ReaisTest() {
		when(clienteService.validarSaldo(CLIENTE_ID, VALOR_90)).thenReturn(true);
		when(clienteService.gerarSaque(CLIENTE_ID, VALOR_90)).thenCallRealMethod();

		List<String> resultado = clienteService.gerarSaque(CLIENTE_ID, VALOR_90);
		assertEquals(resultado.get(0), "R$ 50,00");
		assertEquals(resultado.get(1), "R$ 20,00");
		assertEquals(resultado.get(2), "R$ 20,00");
	}

	/**
	 * Realizar saque no valor de R$530,00
	 */
	@Test
	public void gerarSaqueValor530ReaisTest() {
		when(clienteService.validarSaldo(CLIENTE_ID, VALOR_530)).thenReturn(true);
		when(clienteService.gerarSaque(CLIENTE_ID, VALOR_530)).thenCallRealMethod();

		List<String> resultado = clienteService.gerarSaque(CLIENTE_ID, VALOR_530);
		assertEquals(resultado.get(0), "R$ 100,00");
		assertEquals(resultado.get(1), "R$ 100,00");
		assertEquals(resultado.get(2), "R$ 100,00");
		assertEquals(resultado.get(3), "R$ 100,00");
		assertEquals(resultado.get(4), "R$ 100,00");
		assertEquals(resultado.get(5), "R$ 20,00");
		assertEquals(resultado.get(6), "R$ 10,00");
	}

}
