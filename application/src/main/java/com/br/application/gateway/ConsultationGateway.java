package com.br.application.gateway;

import com.br.core.domain.Consultation;
import com.br.core.domain.Medic;
import com.br.core.domain.Patient;

import java.time.LocalDateTime;

public interface ConsultationGateway {

    Consultation scheduleConsultation(Patient patient, Medic medic, LocalDateTime localDateTime);

    void cancelConsultation(String id, Patient patient, Medic medic, LocalDateTime localDateTime, String reason);

}
