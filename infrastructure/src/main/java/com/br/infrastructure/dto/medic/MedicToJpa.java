package com.br.infrastructure.dto.medic;

import com.br.core.domain.Medic;
import com.br.infrastructure.entity.MedicEntity;

public record MedicToJpa(Medic medic) {

    public MedicEntity toJpa(){
        return MedicEntity.builder()
                .id(medic.getId())
                .name(medic.getName())
                .crm(medic.getCrm())
                .openingHours(medic.getOpeningHours())
                .specialty(medic.getSpecialty())
                .build();
    }
}
