package com.algaworks.serviceorderapi.ServiceOrderapi.api.exceptionhandler;


import java.time.LocalDateTime;
import java.util.ArrayList;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler{

    private MessageSource messageSource;

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
            HttpHeaders headers, HttpStatus status, WebRequest request) {
                var campos = new ArrayList<Problem.Campo>();

                for(ObjectError error : ex.getBindingResult().getAllErrors()){
                    String nome= ((FieldError) error).getField();
                    String mensagem= messageSource.getMessage(error, LocaleContextHolder.getLocale());

                    campos.add(new Problem.Campo(nome, mensagem));
                }

                var problem = new Problem();
                problem.setStatus(status.value());
                problem.setTitulo("Um ou mais campos estão inválidos. "
                        + "Faça o preenchimento correto e tente novamente");
                problem.setDateTime(LocalDateTime.now());
                problem.setCampos(campos);
                
                return super.handleExceptionInternal(ex, problem, headers, status, request);
    }
}
