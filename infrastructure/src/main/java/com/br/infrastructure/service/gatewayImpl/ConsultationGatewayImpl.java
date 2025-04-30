package com.br.infrastructure.service.gatewayImpl;

import com.br.application.gateway.ConsultationGateway;
import com.br.core.domain.Consultation;
import com.br.core.domain.Medic;
import com.br.core.domain.Patient;
import com.br.core.enums.Specialty;
import com.br.usecases.ConsultationUsecases;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Component
public class ConsultationGatewayImpl implements ConsultationGateway {


    @Override
    public List<Medic> checkAvailability(Specialty specialty, LocalDate localDate) {
    }

    @Override
    public Consultation scheduleConsultation(Patient patient, Medic medic, LocalDateTime localDateTime) {

    }

    @Override
    public void cancelConsultation(Patient patient, Medic medic, LocalDateTime localDateTime, String reason) {

    }
}
