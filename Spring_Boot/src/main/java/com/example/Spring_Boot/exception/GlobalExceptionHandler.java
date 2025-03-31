package com.example.Spring_Boot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(RecursoNaoEncontrado.class)
    public ResponseEntity<?> handleRecursoNaoEncontrado(RecursoNaoEncontrado ex) {

            Map<String, Object> resposta = new HashMap<>();
            resposta.put("timestamp", LocalDateTime.now());
            resposta.put("status", HttpStatus.NOT_FOUND.value());
            resposta.put("erro", "Recurso não encontrado");
            resposta.put("mensagem", ex.getMessage());
            return new ResponseEntity<>(resposta, HttpStatus.NOT_FOUND);
        }
        @ExceptionHandler(Exception.class)
        public ResponseEntity<?> handleGlobalException(Exception ex) {
            Map<String, Object> resposta = new HashMap<>();
            resposta.put("timestamp", LocalDateTime.now());
            resposta.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
            resposta.put("erro", "Erro interno do servidor");
            resposta.put("mensagem", ex.getMessage());
            return new ResponseEntity<>(resposta, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }





