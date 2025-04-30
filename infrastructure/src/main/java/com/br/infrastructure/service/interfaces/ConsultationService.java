package com.br.infrastructure.service.interfaces;

import com.br.infrastructure.dto.consultation.ConsultationCancelDTO;
import com.br.infrastructure.dto.consultation.ConsultationCreationDTO;
import com.br.infrastructure.dto.consultation.ConsultationDataAvailability;
import com.br.infrastructure.dto.medic.MedicDetailsDTO;

import java.util.List;

public interface ConsultationService {

    String saveConsultation(ConsultationCreationDTO consultationCreationDTO);

    void cancelConsultation(ConsultationCancelDTO consultationCancelDTO);
}
