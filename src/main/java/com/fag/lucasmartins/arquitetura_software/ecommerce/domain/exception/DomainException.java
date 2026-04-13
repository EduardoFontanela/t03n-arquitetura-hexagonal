package com.fag.lucasmartins.arquitetura_software.ecommerce.domain.exception;

public class DomainException extends RuntimeException {
    
    public DomainException(String message) {
        super(message);
    }
}