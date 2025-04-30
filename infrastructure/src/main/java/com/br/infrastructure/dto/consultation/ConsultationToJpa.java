package com.br.infrastructure.dto.consultation;

import com.br.core.domain.Consultation;
import com.br.infrastructure.dto.medic.MedicToJpa;
import com.br.infrastructure.dto.patient.PatientToJpa;
import com.br.infrastructure.entity.ConsultationEntity;

public record ConsultationToJpa(Consultation consultation) {

    public ConsultationEntity toJpa(){
        return ConsultationEntity.builder()
                .id(consultation.getId())
                .patientEntity(new PatientToJpa(consultation.getPatient()).toJpa())
                .medicEntity(new MedicToJpa(consultation.getMedic()).toJpa())
                .hour(consultation.getHour())
                .status(consultation.getStatus())
                .reasonCancellation(consultation.getReasonCancellation())
                .build();
    }
}
