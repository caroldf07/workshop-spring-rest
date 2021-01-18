package com.algaworks.serviceorderapi.ServiceOrderapi.api.exceptionhandler;

import java.time.LocalDateTime;
import java.util.List;

public class Problem {
    private Integer status;
    private LocalDateTime dateTime;
    private String titulo;
    private List<Campo> campos;

    public static class Campo{
        private String nome;
        private String mensagem;

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public String getMensagem() {
            return mensagem;
        }

        public void setMensagem(String mensagem) {
            this.mensagem = mensagem;
        }

        public Campo(String nome, String mensagem) {
            this.nome = nome;
            this.mensagem = mensagem;
        }
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }
    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public Integer getStatus() {
        return status;
    }
    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public List<Campo> getCampos() {
        return campos;
    }


    public void setCampos(List<Campo> campos) {
        this.campos = campos;
    }
}
