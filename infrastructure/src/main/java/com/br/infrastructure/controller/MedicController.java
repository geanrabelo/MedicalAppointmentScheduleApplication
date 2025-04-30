package com.br.infrastructure.controller;

import com.br.infrastructure.dto.MessageDTO;
import com.br.infrastructure.dto.medic.MedicCreationDTO;
import com.br.infrastructure.service.interfaces.MedicService;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(name = "tb_medic")
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
}
