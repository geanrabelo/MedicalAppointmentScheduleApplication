package com.br.infrastructure.service.gatewayImpl;

import com.br.application.gateway.ConsultationGateway;
import com.br.core.domain.Consultation;
import com.br.core.domain.Medic;
import com.br.core.domain.Patient;
import com.br.core.enums.EnumCode;
import com.br.core.enums.Specialty;
import com.br.core.enums.Status;
import com.br.core.exceptions.MedicHourNotAvailable;
import com.br.core.exceptions.MedicNotFound;
import com.br.core.exceptions.PatientNotFound;
import com.br.infrastructure.dto.consultation.ConsultationToJpa;
import com.br.infrastructure.entity.ConsultationEntity;
import com.br.infrastructure.entity.MedicEntity;
import com.br.infrastructure.entity.PatientEntity;
import com.br.infrastructure.repository.ConsultationEntityRepository;
import com.br.infrastructure.repository.MedicEntityRepository;
import com.br.infrastructure.repository.PatientEntityRepository;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
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
    public Consultation scheduleConsultation(Patient patient, Medic medic, LocalDateTime localDateTime) {
        if(patientEntityRepository.existsById(patient.getId()) && medicEntityRepository.existsById(medic.getId())){
            MedicEntity medicEntityDB = medicEntityRepository.getReferenceById(medic.getId());
            PatientEntity patientEntityDB = patientEntityRepository.getReferenceById(patient.getId());
            Optional<LocalDateTime> hour = medicEntityDB
                    .getOpeningHours().stream().filter(h -> h.equals(localDateTime)).findFirst();
            if(hour.isPresent()){
                List<LocalDateTime> newOpeningHours = new ArrayList<>();
                for(LocalDateTime hours : medicEntityDB.getOpeningHours()){
                    if(hour.get() != hours){
                        newOpeningHours.add(hours);
                    }
                }
                medicEntityDB.setOpeningHours(newOpeningHours);
                medicEntityRepository.save(medicEntityDB);
                ConsultationEntity consultationEntity = ConsultationEntity.builder()
                        .patientEntity(patientEntityDB)
                        .medicEntity(medicEntityDB)
                        .hour(hour.get())
                        .status(Status.SCHEDULED)
                        .build();
                consultationEntityRepository.save(consultationEntity);
            }
            throw new MedicHourNotAvailable(EnumCode.MED0003.getMessage());
        } else if (!patientEntityRepository.existsById(patient.getId())) {
            throw new PatientNotFound(EnumCode.PAT0000.getMessage());
        }else {
            throw new MedicNotFound(EnumCode.MED0000.getMessage());
        }
    }

    @Override
    public void cancelConsultation(String id, Patient patient, Medic medic, LocalDateTime localDateTime, String reason) {
        if(patientEntityRepository.existsById(patient.getId())
                && medicEntityRepository.existsById(medic.getId())
                && consultationEntityRepository.existsById(id)){
            MedicEntity medicEntityDB = medicEntityRepository.getReferenceById(medic.getId());
            PatientEntity patientEntityDB = patientEntityRepository.getReferenceById(patient.getId());
            List<LocalDateTime> openHour = medicEntityDB.getOpeningHours();
            openHour.add(localDateTime);
            medicEntityRepository.save(medicEntityDB);
            ConsultationEntity consultationEntityDB = consultationEntityRepository.getReferenceById(id);
            consultationEntityDB.setReasonCancellation(reason);
            consultationEntityDB.setStatus(Status.CANCELLED);
            consultationEntityRepository.save(consultationEntityDB);
        } else if (!patientEntityRepository.existsById(patient.getId())) {
            throw new PatientNotFound(EnumCode.PAT0000.getMessage());
        }else {
            throw new MedicNotFound(EnumCode.MED0000.getMessage());
        }
    }
}
