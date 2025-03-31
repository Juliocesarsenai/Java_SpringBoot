package com.example.Spring_Boot.exception;

public class RecursoNaoEncontrado extends RuntimeException {
    public RecursoNaoEncontrado(String message) {
        super(message);
    }
}
