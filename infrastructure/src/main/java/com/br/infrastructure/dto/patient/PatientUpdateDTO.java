package com.br.infrastructure.dto.patient;

import com.br.core.domain.Patient;

public record PatientUpdateDTO(Long id,
                               String email,
                               String numberPhone) {
    public Patient toPatient(){
        return new Patient.PatientBuilder()
                .builder()
                .id(id)
                .email(email)
                .numberPhone(numberPhone)
                .build();
    }
}
