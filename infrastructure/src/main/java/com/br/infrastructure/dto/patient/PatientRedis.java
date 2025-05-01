package com.br.infrastructure.dto.patient;

import com.br.infrastructure.entity.PatientEntity;

import java.time.LocalDate;

public record PatientRedis(Long id,
                           String name,
                           String cpf,
                           String email,
                           String numberPhone,
                           LocalDate dateOfBirth) {

    public PatientRedis(PatientEntity patientEntity){
        this(patientEntity.getId(),
                patientEntity.getName(),
                patientEntity.getCpf(),
                patientEntity.getEmail(),
                patientEntity.getNumberPhone(),
                patientEntity.getDateOfBirth()
        );
    }
}
