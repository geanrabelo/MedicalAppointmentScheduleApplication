package com.br.core.exceptions;

public class PatientConflict extends RuntimeException {
    public PatientConflict(String message) {
        super(message);
    }
}
