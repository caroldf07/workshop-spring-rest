package com.algaworks.serviceorderapi.ServiceOrderapi.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank //não vai aceitar vazio, null ou só espaço
    @Column(name = "nome")
    @Size(max=60)
    private String name;
    
    @NotBlank
    @Email //valida não somente se o email é null, mas também valida se é um formato válido
    @Size(max=255)
    private String email;
    
    @NotBlank
    @Column(name = "telefone")
    @Size(max=20)
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
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
