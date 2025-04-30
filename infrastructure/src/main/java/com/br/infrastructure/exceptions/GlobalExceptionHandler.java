package com.br.infrastructure.exceptions;

import com.br.core.exceptions.*;
import com.br.infrastructure.exceptions.dto.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MedicNotFound.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse medicNotFoundHandler(MedicNotFound medicNotFound){
        return ErrorResponse.notFound(medicNotFound.getMessage());
    }

    @ExceptionHandler(MedicConflict.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ErrorResponse medicConflictHandler(MedicConflict medicConflict){
        return ErrorResponse.conflict(medicConflict.getMessage());
    }

    @ExceptionHandler(MedicHourNotAvailable.class)
    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    public ErrorResponse medicHourNotAvailableHandler(MedicHourNotAvailable medicHourNotAvailable){
        return ErrorResponse.invalid(medicHourNotAvailable.getMessage());
    }

    @ExceptionHandler(PatientNotFound.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse patientNotFoundHandler(PatientNotFound patientNotFound){
        return ErrorResponse.notFound(patientNotFound.getMessage());
    }

    @ExceptionHandler(PatientConflict.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ErrorResponse patientConflictHandler(PatientConflict patientConflict){
        return ErrorResponse.conflict(patientConflict.getMessage());
    }

}
