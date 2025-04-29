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
    public List<Medic> checkAvailability(Specialty specialty, LocalDate localDate) {
        return consultationGateway.checkAvailability(specialty, localDate);
    }

    @Override
    public Consultation scheduleConsultation(Patient patient, Medic medic, LocalDateTime localDateTime) {
        return consultationGateway.scheduleConsultation(patient, medic, localDateTime);
    }

    @Override
    public void cancelConsultation(Patient patient, Medic medic, LocalDateTime localDateTime, String reason) {
        consultationGateway.cancelConsultation(patient, medic, localDateTime, reason);
    }
}
