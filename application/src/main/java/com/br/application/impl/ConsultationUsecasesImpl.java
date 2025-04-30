package com.br.application.impl;

import com.br.application.gateway.ConsultationGateway;
import com.br.core.domain.Consultation;
import com.br.core.domain.Medic;
import com.br.core.domain.Patient;
import com.br.core.enums.Specialty;
import com.br.usecases.ConsultationUsecases;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class ConsultationUsecasesImpl implements ConsultationUsecases {

    private final ConsultationGateway consultationGateway;

    public ConsultationUsecasesImpl(ConsultationGateway consultationGateway){
        this.consultationGateway = consultationGateway;
    }

    @Override
    public Consultation scheduleConsultation(Patient patient, Medic medic, LocalDateTime localDateTime) {
        return consultationGateway.scheduleConsultation(patient, medic, localDateTime);
    }

    @Override
    public void cancelConsultation(String id, Patient patient, Medic medic, LocalDateTime localDateTime, String reason) {
        consultationGateway.cancelConsultation(id, patient, medic, localDateTime, reason);
    }
}
