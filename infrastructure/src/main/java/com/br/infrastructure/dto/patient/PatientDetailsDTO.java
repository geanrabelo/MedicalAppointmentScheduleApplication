package com.br.infrastructure.dto.patient;

import com.br.core.domain.Patient;

import java.time.LocalDate;

public record PatientDetailsDTO(Long id,
                                String name,
                                String cpf,
                                String email,
                                String numberPhone,
                                LocalDate dateOfBirth) {

    public PatientDetailsDTO(Patient patient){
        this(
                patient.getId(),
                patient.getName(),
                patient.getCpf(),
                patient.getEmail(),
                patient.getNumberPhone(),
                patient.getDateOfBirth()
        );
    }
}
