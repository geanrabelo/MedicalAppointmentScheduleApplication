package com.br.infrastructure.dto.patient;

import com.br.core.domain.Patient;

import java.time.LocalDate;

public record PatientCreationDTO(String name,
                                 String cpf,
                                 String email,
                                 String numberPhone,
                                 LocalDate dateOfBirth) {

    public Patient toPatient(){
        return new Patient.PatientBuilder()
                .builder()
                .name(name)
                .cpf(cpf)
                .email(email)
                .numberPhone(numberPhone)
                .dateOfBirth(dateOfBirth)
                .build();
    }

}
