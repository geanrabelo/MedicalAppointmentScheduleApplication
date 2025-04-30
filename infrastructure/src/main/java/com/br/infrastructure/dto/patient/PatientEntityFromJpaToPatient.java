package com.br.infrastructure.dto.patient;

import com.br.core.domain.Patient;
import com.br.infrastructure.entity.PatientEntity;

public record PatientEntityFromJpaToPatient(PatientEntity patientEntity) {

    public Patient jpaToPatient(){
        return new Patient.PatientBuilder().builder()
                .id(patientEntity.getId())
                .name(patientEntity.getName())
                .email(patientEntity.getEmail())
                .numberPhone(patientEntity.getNumberPhone())
                .cpf(patientEntity.getCpf())
                .dateOfBirth(patientEntity.getDateOfBirth())
                .build();
    }
}
