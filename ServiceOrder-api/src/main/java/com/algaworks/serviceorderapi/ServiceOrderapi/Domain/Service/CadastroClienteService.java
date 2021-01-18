package com.algaworks.serviceorderapi.ServiceOrderapi.Domain.Service;

import com.algaworks.serviceorderapi.ServiceOrderapi.domain.model.Client;
import com.algaworks.serviceorderapi.ServiceOrderapi.domain.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CadastroClienteService {

    @Autowired
    private ClientRepository clienteRepository;

    public Client salvar(Client cliente){
        return clienteRepository.save(cliente);
    }

    public void excluir(Long clienteId){
        clienteRepository.deleteById(clienteId);
    }
}
