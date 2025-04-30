package com.br.core.exceptions;

public class MedicNotFound extends RuntimeException{
    private String message;

    public MedicNotFound(String message){
        super(message);
    }
}
