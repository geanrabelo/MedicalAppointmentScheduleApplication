package com.br.infrastructure.controller;

import com.br.infrastructure.dto.MessageDTO;
import com.br.infrastructure.dto.medic.MedicCreationDTO;
import com.br.infrastructure.dto.medic.MedicDetailsDTO;
import com.br.infrastructure.service.interfaces.MedicService;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/medical/medic")
public class MedicController {

    private final MedicService medicService;

    public MedicController(MedicService medicService){
        this.medicService = medicService;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<MessageDTO> saveMedic(@RequestBody @Validated MedicCreationDTO medicCreationDTO){
        String message = medicService.saveMedic(medicCreationDTO);
        return ResponseEntity.ok(new MessageDTO(message));
    }

    @GetMapping
    public ResponseEntity<List<MedicDetailsDTO>> findAll(){
        return ResponseEntity.ok(medicService.findAll());
    }

    @GetMapping("/id")
    public ResponseEntity<MedicDetailsDTO> findById(@RequestParam(name = "id") Long id){
        MedicDetailsDTO medicDetailsDTO = medicService.findById(id);
        return ResponseEntity.ok(medicDetailsDTO);
    }

    @GetMapping("/crm")
    public ResponseEntity<MedicDetailsDTO> findByCrm(@RequestParam(name = "crm") String crm){
        MedicDetailsDTO medicDetailsDTO = medicService.findByCrm(crm);
        return ResponseEntity.ok(medicDetailsDTO);
    }

    @DeleteMapping
    @Transactional
    public ResponseEntity<Void> deleteById(@RequestParam(name = "id") Long id){
        medicService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
