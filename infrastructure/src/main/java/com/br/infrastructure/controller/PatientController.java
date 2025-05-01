package com.br.infrastructure.controller;

import com.br.infrastructure.dto.MessageDTO;
import com.br.infrastructure.dto.patient.PatientCreationDTO;
import com.br.infrastructure.service.interfaces.PatientService;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/medical/patient")
public class PatientController {

    private final PatientService patientService;

    public PatientController(PatientService patientService){
        this.patientService = patientService;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<MessageDTO> savePatient(@RequestBody @Validated PatientCreationDTO patientCreationDTO){
        String message = patientService.savePatient(patientCreationDTO);
        return new ResponseEntity.ok(new MessageDTO(message));
    }
}
