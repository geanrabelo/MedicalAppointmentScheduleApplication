package com.br.infrastructure.dto.patient;

import com.br.infrastructure.entity.PatientEntity;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public record PatientRedis(Long id,
                           String name,
                           String cpf,
                           String email,
                           String numberPhone,
                           @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
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
