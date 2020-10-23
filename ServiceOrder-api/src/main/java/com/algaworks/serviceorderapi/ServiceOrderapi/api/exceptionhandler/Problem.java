package com.algaworks.serviceorderapi.ServiceOrderapi.api.exceptionhandler;

import java.time.LocalDateTime;

public class Problem {
    private Integer status;
    private LocalDateTime dateTime;
    private String titulo;

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
}
