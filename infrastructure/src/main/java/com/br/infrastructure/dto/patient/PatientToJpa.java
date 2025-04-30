package com.br.infrastructure.dto.patient;

import com.br.core.domain.Patient;
import com.br.infrastructure.entity.PatientEntity;

public record PatientToJpa(Patient patient) {

    public PatientEntity toJpa(){
        return PatientEntity.builder()
                .id(patient.getId())
                .name(patient.getName())
                .cpf(patient.getCpf())
                .numberPhone(patient.getNumberPhone())
                .email(patient.getEmail())
                .dateOfBirth(patient.getDateOfBirth())
                .build();
    }
}
