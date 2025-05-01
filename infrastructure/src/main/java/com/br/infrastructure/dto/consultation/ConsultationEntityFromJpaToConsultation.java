package com.br.infrastructure.dto.consultation;

import com.br.core.domain.Consultation;
import com.br.infrastructure.dto.medic.MedicEntityFromJpaToMedic;
import com.br.infrastructure.dto.patient.PatientEntityFromJpaToPatient;
import com.br.infrastructure.entity.ConsultationEntity;

public record ConsultationEntityFromJpaToConsultation(ConsultationEntity consultationEntity) {

    public Consultation toConsultation(){
        return new Consultation.ConsultationBuilder()
                .builder()
                .id(consultationEntity.getId())
                .patient(new PatientEntityFromJpaToPatient(consultationEntity.getPatientEntity()).jpaToPatient())
                .medic(new MedicEntityFromJpaToMedic(consultationEntity.getMedicEntity()).jpaToMedic())
                .status(consultationEntity.getStatus())
                .hour(consultationEntity.getHour())
                .reasonCancellation(consultationEntity.getReasonCancellation())
                .build();
    }
}
