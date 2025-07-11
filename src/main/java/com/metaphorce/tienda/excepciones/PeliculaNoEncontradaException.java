package com.metaphorce.tienda.excepciones;

public class PeliculaNoEncontradaException extends RuntimeException {
    public PeliculaNoEncontradaException(String mensaje) {
        super(mensaje);
    }
}
