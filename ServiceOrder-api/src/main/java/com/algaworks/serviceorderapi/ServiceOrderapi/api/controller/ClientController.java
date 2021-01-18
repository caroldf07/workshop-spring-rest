package com.algaworks.serviceorderapi.ServiceOrderapi.api.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.algaworks.serviceorderapi.ServiceOrderapi.Domain.Service.CadastroClienteService;
import com.algaworks.serviceorderapi.ServiceOrderapi.domain.model.Client;
import com.algaworks.serviceorderapi.ServiceOrderapi.domain.repository.ClientRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

//Mapeamento de caminhos
@RestController
@RequestMapping("/clientes")
public class ClientController{

	@Autowired
	private ClientRepository clientRepository;

	@Autowired
	private CadastroClienteService cadastroCliente;

	//Configurando o GET
	@GetMapping
	public List<Client> listar(){
		return clientRepository.findAll();
	}

	@GetMapping("/{clientId}")
	public ResponseEntity <Client> buscar (@PathVariable Long clientId){
		Optional<Client> client = clientRepository.findById(clientId);

		//Configurando o retorno do GET 200
		if(client.isPresent()){
			return ResponseEntity.ok(client.get());
		}

		return ResponseEntity.notFound().build();
	}

	//Configurando o POST
	@PostMapping
	//Configurando o retorno do POST 201
	@ResponseStatus(HttpStatus.CREATED)
	public Client postar(@Valid @RequestBody Client client){
		return cadastroCliente.salvar(client);
	}

	//Configurando o PUT
	@PutMapping("/{clientId}")
	public ResponseEntity<Client> atualizar(@Valid @PathVariable Long clientId,
		@RequestBody Client client){
			if(!clientRepository.existsById(clientId)){
				return ResponseEntity.notFound().build();
			}

			//Para atualizar e não criar um novo
			client.setId(clientId);
			cadastroCliente.salvar(client);
			return ResponseEntity.ok(client);
	}

	//Configurando a exclusão
	@DeleteMapping("/{clientId}")
	public ResponseEntity<Void> remover(@PathVariable Long clientId){
		if(!clientRepository.existsById(clientId)){
			return ResponseEntity.notFound().build();
		}
		cadastroCliente.excluir(clientId);
		//consta que foi deletado, mas não vai retornar nada no corpo
		return ResponseEntity.noContent().build();
	}
}


