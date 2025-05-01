package com.br.infrastructure.service.servicesImpl;

import com.br.core.domain.Consultation;
import com.br.core.domain.Medic;
import com.br.core.domain.Patient;
import com.br.core.enums.EnumCode;
import com.br.core.exceptions.ConsultationNotFound;
import com.br.infrastructure.dto.consultation.ConsultationCancelDTO;
import com.br.infrastructure.dto.consultation.ConsultationCreationDTO;
import com.br.infrastructure.repository.ConsultationEntityRepository;
import com.br.infrastructure.service.interfaces.ConsultationService;
import com.br.usecases.ConsultationUsecases;
import com.br.usecases.MedicUsecases;
import com.br.usecases.PatientUsecases;
import org.springframework.stereotype.Service;


@Service
public class ConsultationServiceImpl implements ConsultationService {

    private final ConsultationUsecases consultationUsecases;
    private final PatientUsecases patientUsecases;
    private final MedicUsecases medicUsecases;
    private final ConsultationEntityRepository consultationEntityRepository;

    public ConsultationServiceImpl(ConsultationUsecases consultationUsecases,
                                   PatientUsecases patientUsecases,
                                   MedicUsecases medicUsecases,
                                   ConsultationEntityRepository consultationEntityRepository){
        this.consultationUsecases = consultationUsecases;
        this.patientUsecases = patientUsecases;
        this.medicUsecases = medicUsecases;
        this.consultationEntityRepository = consultationEntityRepository;
    }

    @Override
    public String saveConsultation(ConsultationCreationDTO consultationCreationDTO) {
        Patient patient = patientUsecases.findById(consultationCreationDTO.patient_id());
        Medic medic = medicUsecases.findById(consultationCreationDTO.medic_id());
        Consultation consultation = consultationUsecases.scheduleConsultation(patient, medic, consultationCreationDTO.hour());
        return "ConsultationId: "+consultation.getId()+" scheduled successfully";
    }

    @Override
    public void cancelConsultation(ConsultationCancelDTO consultationCancelDTO) {
        if(consultationEntityRepository.existsById(consultationCancelDTO.id())){
            Patient patient = patientUsecases.findById(consultationCancelDTO.patient_id());
            Medic medic = medicUsecases.findById(consultationCancelDTO.medic_id());
            consultationUsecases.cancelConsultation(consultationCancelDTO.id(),
                    patient,
                    medic,
                    consultationCancelDTO.hour(),
                    consultationCancelDTO.reason());
        }else{
            throw new ConsultationNotFound(EnumCode.CON0001.getMessage());
        }
    }
}
