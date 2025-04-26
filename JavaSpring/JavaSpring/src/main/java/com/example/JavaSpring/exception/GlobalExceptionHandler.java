package com.example.JavaSpring.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(RecursoNaoEncontrado.class)
    public ResponseEntity<?> handleRecursoNaoEncontrado(RecursoNaoEncontrado ex){
        Map<String,Object> erro = new HashMap<>();
        erro.put("timestamp", LocalDateTime.now());
        erro.put("status", HttpStatus.NOT_FOUND.value());
        erro.put("erro","Recurso não encontrado");
        erro.put("mensagem",ex.getMessage());
        return new ResponseEntity<>(erro,HttpStatus.NOT_FOUND);

    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleGlobalException(Exception ex){
        Map<String,Object> erro = new HashMap<>();
        erro.put("timestamp", LocalDateTime.now());
        erro.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
        erro.put("erro","ERRO INTERNO DO SERVIDOR");
        erro.put("mensagem",ex.getMessage());
        return new ResponseEntity<>(erro,HttpStatus.INTERNAL_SERVER_ERROR);

    }


}
