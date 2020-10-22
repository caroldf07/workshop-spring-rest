package com.algaworks.serviceorderapi.ServiceOrderapi.api.controller;

import java.util.List;
import java.util.Optional;

import com.algaworks.serviceorderapi.ServiceOrderapi.domain.model.Client;
import com.algaworks.serviceorderapi.ServiceOrderapi.domain.repository.ClientRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clientes")
public class ClientController{

	@Autowired
	private ClientRepository clientRepository;

	@GetMapping
	public List<Client> listar(){
		return clientRepository.findAll();
	}

	@GetMapping("/{clientId}")
	public ResponseEntity <Client> buscar (@PathVariable Long clientId){
		Optional<Client> client = clientRepository.findById(clientId);

		if(client.isPresent()){
			return ResponseEntity.ok(client.get());
		}

		return ResponseEntity.notFound().build();
	}
}


