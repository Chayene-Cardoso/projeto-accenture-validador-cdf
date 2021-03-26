package com.validador.cpf.validadorDeCpf;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.validador.cpf.validadorDeCpf.models.Cliente;

@SpringBootTest
class validadorDeCpfApplicationTests {

	@Test
	@DisplayName("Dado que eu faça um teste com CPF válido")
	void fazendoTesteDeCpfValido() {
		Cliente cliente = new Cliente();
		cliente.setNome("Chay");
		cliente.setCpf("77013979066");
		assertEquals(true, cliente.validarCPF());
	}

	@Test
	void fazendoTesteDeCpfInvalido() {
		Cliente cliente = new Cliente();
		cliente.setNome("Chay");
		cliente.setCpf("77013979000");
		assertEquals(false, cliente.validarCPF());
	}

	@Test
	void fazendoTesteDeCpfComDigitoAMenos() {
		Cliente cliente = new Cliente();
		cliente.setNome("Chay");
		cliente.setCpf("7701397906");
		assertEquals(false, cliente.validarCPF());
	}

	@Test
	void fazendoTesteDeCpfValidoComPontos() {
		Cliente cliente = new Cliente();
		cliente.setNome("Chay");
		cliente.setCpf("770.139.790-66");
		assertEquals(true, cliente.validarCPF());
	}

	@Test
	void fazendoTesteDeCpfInvalidoComPontos() {
		Cliente cliente = new Cliente();
		cliente.setNome("Chay");
		cliente.setCpf("770.139.790-00");
		assertEquals(false, cliente.validarCPF());
	}

	@Test
	void fazendoTesteDeCpfInvalidoComVirgula() {
		Cliente cliente = new Cliente();
		cliente.setNome("Chay");
		cliente.setCpf("770,139.790-66");
		assertEquals(false, cliente.validarCPF());
	}

	@Test
	void fazendoTesteDeCpfInvalidoComEspacoNoFinal() {
		Cliente cliente = new Cliente();
		cliente.setNome("Chay");
		cliente.setCpf("770.139.790-66 ");
		assertEquals(true, cliente.validarCPF());
	}
	
	@Test
	void fazendoTesteDeCpfInvalidoComEspacoNoComeco() {
		Cliente cliente = new Cliente();
		cliente.setNome("Chay");
		cliente.setCpf(" 770.139.790-66");
		assertEquals(true, cliente.validarCPF());
	}
	
	@Test
	void fazendoTesteDeCpfInvalidoComEspacoNoMeio() {
		Cliente cliente = new Cliente();
		cliente.setNome("Chay");
		cliente.setCpf("770.139. 790-66");
		assertEquals(true, cliente.validarCPF());
	}

	@Test
	void fazendoTesteDeCpfDoidoQuePassou() {
		Cliente cliente = new Cliente(); 
		cliente.setNome("Chay");
		cliente.setCpf("69b.969.790-88");
		assertEquals(false, cliente.validarCPF());
	}

	@Test
	void fazendoTesteSemPassarCPF() {
		Cliente cliente = new Cliente();
		cliente.setNome("Chay");
		assertEquals(false, cliente.validarCPF());
	}
}
