package com.algaworks.serviceorderapi.ServiceOrderapi.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String name;
    
    private String email;
    
    @Column(name = "telefone")
    private String phone;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
        return true;
        if(obj == null)
        return false;
        if(getClass() != obj.getClass())
        return false;
        Client other = (Client) obj;
        if(id == null){
            if(other.id != null)
            return false;
        } else if (!id.equals(other.id))
        return false;
        return true;
    }

}