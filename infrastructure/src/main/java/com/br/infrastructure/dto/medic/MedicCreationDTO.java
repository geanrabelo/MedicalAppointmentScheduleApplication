package com.br.infrastructure.dto.medic;

import com.br.core.domain.Medic;
import com.br.core.enums.Specialty;

public record MedicCreationDTO(String name,
                               String crm,
                               Specialty specialty) {

    public Medic toMedic(){
        return new Medic.MedicBuilder()
                .builder()
                .name(name)
                .crm(crm)
                .speciality(specialty)
                .build();
    }
}
