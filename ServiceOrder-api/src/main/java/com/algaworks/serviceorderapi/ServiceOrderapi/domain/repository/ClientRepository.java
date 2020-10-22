package com.algaworks.serviceorderapi.ServiceOrderapi.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.algaworks.serviceorderapi.ServiceOrderapi.domain.model.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
    
}
