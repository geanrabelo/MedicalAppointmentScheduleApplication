package com.br.infrastructure.service.interfaces;

import com.br.infrastructure.dto.ConsultationCancelDTO;
import com.br.infrastructure.dto.ConsultationCreationDTO;
import com.br.infrastructure.dto.ConsultationDataAvailability;
import com.br.infrastructure.dto.MedicDetailsDTO;

import java.util.List;

public interface ConsultationService {

    List<MedicDetailsDTO> checkAvailability(ConsultationDataAvailability consultationDataAvailability);

    String saveConsultation(ConsultationCreationDTO consultationCreationDTO);

    void cancelConsultation(ConsultationCancelDTO consultationCancelDTO);
}
