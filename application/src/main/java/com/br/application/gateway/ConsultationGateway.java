package com.br.application.gateway;

import com.br.core.domain.Consultation;
import com.br.core.domain.Medic;
import com.br.core.domain.Patient;
import com.br.core.enums.Specialty;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface ConsultationGateway {

    List<Medic> checkAvailability(Specialty specialty, LocalDate localDate);

    Consultation scheduleConsultation(Patient patient, Medic medic, LocalDateTime localDateTime);

    void cancelConsultation(String id, Patient patient, Medic medic, LocalDateTime localDateTime, String reason);

}
