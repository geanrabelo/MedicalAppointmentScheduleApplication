package com.br.infrastructure.controller;

import com.br.infrastructure.dto.MessageDTO;
import com.br.infrastructure.dto.patient.PatientCreationDTO;
import com.br.infrastructure.dto.patient.PatientDetailsDTO;
import com.br.infrastructure.dto.patient.PatientUpdateDTO;
import com.br.infrastructure.service.interfaces.PatientService;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
        return ResponseEntity.ok(new MessageDTO(message));
    }

    @GetMapping
    public ResponseEntity<List<PatientDetailsDTO>> findAll(){
        return ResponseEntity.ok(patientService.findAll());
    }

    @GetMapping("/id")
    public ResponseEntity<PatientDetailsDTO> findById(@RequestParam(name = "id") Long id){
        return ResponseEntity.ok(patientService.findById(id));
    }

    @GetMapping("/cpf")
    public ResponseEntity<PatientDetailsDTO> findByCpf(@RequestParam(name = "cpf") String cpf){
        return ResponseEntity.ok(patientService.findByCpf(cpf));
    }

    @PutMapping
    @Transactional
    public ResponseEntity<PatientDetailsDTO> update(@RequestBody PatientUpdateDTO patientUpdateDTO){
        return ResponseEntity.ok(patientService.update(patientUpdateDTO));
    }

    @DeleteMapping
    @Transactional
    public ResponseEntity<Void> deleteById(@RequestParam(name = "id") Long id){
        patientService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
