package com.br.infrastructure.controller;

import com.br.infrastructure.dto.MessageDTO;
import com.br.infrastructure.dto.consultation.ConsultationCancelDTO;
import com.br.infrastructure.dto.consultation.ConsultationCreationDTO;
import com.br.infrastructure.service.interfaces.ConsultationService;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/medical/consultation")
public class ConsultationController {

    private final ConsultationService consultationService;

    public ConsultationController(ConsultationService consultationService){
        this.consultationService = consultationService;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<MessageDTO> saveConsultation(@RequestBody @Validated ConsultationCreationDTO consultationCreationDTO){
        String message = consultationService.saveConsultation(consultationCreationDTO);
        return ResponseEntity.ok(new MessageDTO(message));
    }

    @DeleteMapping
    @Transactional
    public ResponseEntity<Void> cancelConsultation(@RequestBody @Validated ConsultationCancelDTO consultationCancelDTO){
        consultationService.cancelConsultation(consultationCancelDTO);
        return ResponseEntity.noContent().build();
    }
}
