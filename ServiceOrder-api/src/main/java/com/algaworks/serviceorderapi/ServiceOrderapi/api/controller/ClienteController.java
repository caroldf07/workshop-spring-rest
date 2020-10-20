package com.algaworks.serviceorderapi.ServiceOrderapi.api.controller;

import java.util.Arrays;
import java.util.List;

import com.algaworks.serviceorderapi.ServiceOrderapi.domain.model.Cliente;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClienteController{
	@GetMapping("/clientes")
	public List<Cliente> listar(){
		var cliente1 = new Cliente();
		cliente1.setId(1L);
		cliente1.setName("Carolina");
		cliente1.setEmail("carolina@teste.com.br");
		cliente1.setPhone("11111111111");

		var cliente2 = new Cliente();
		cliente2.setId(2L);
		cliente2.setName("Ana");
		cliente2.setEmail("ana@teste.com.br");
		cliente2.setPhone("22222222222");

		return Arrays.asList(cliente1,cliente2);
	}
}


