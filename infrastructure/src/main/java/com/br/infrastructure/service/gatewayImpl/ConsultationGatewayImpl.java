package com.br.infrastructure.service.gatewayImpl;

import com.br.application.gateway.ConsultationGateway;
import com.br.core.domain.Consultation;
import com.br.core.domain.Medic;
import com.br.core.domain.Patient;
import com.br.core.enums.EnumCode;
import com.br.core.enums.Specialty;
import com.br.core.exceptions.MedicHourNotAvailable;
import com.br.infrastructure.entity.MedicEntity;
import com.br.infrastructure.entity.PatientEntity;
import com.br.infrastructure.repository.ConsultationEntityRepository;
import com.br.infrastructure.repository.MedicEntityRepository;
import com.br.infrastructure.repository.PatientEntityRepository;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Component
public class ConsultationGatewayImpl implements ConsultationGateway {

    private final ConsultationEntityRepository consultationEntityRepository;
    private final MedicEntityRepository medicEntityRepository;
    private final PatientEntityRepository patientEntityRepository;

    public ConsultationGatewayImpl(ConsultationEntityRepository consultationEntityRepository,
                                   MedicEntityRepository medicEntityRepository,
                                   PatientEntityRepository patientEntityRepository){
        this.consultationEntityRepository = consultationEntityRepository;
        this.medicEntityRepository = medicEntityRepository;
        this.patientEntityRepository = patientEntityRepository;
    }

    @Override
    public List<Medic> checkAvailability(Specialty specialty, LocalDate localDate) {

    }

    @Override
    public Consultation scheduleConsultation(Patient patient, Medic medic, LocalDateTime localDateTime) {
        if(patientEntityRepository.existsById(patient.getId()) && medicEntityRepository.existsById(medic.getId())){
            MedicEntity medicEntityDB = medicEntityRepository.getReferenceById(medic.getId());
            PatientEntity patientEntityDB = patientEntityRepository.getReferenceById(patient.getId());
            Optional<LocalDateTime> hour = medicEntityDB
                    .getOpeningHours().stream().filter(h -> h.equals(localDateTime)).findFirst();
            if(hour.isPresent()){

            }
            throw new MedicHourNotAvailable(EnumCode.MED0003.getMessage());
        }
    }

    @Override
    public void cancelConsultation(Patient patient, Medic medic, LocalDateTime localDateTime, String reason) {

    }
}
