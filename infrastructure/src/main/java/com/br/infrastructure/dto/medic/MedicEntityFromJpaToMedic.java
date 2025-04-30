package com.br.infrastructure.dto.medic;

import com.br.core.domain.Medic;
import com.br.infrastructure.entity.MedicEntity;

public record MedicEntityFromJpaToMedic(MedicEntity medicEntity) {

    public Medic jpaToMedic(){
        return new Medic.MedicBuilder().builder()
                .id(medicEntity.getId())
                .name(medicEntity.getName())
                .crm(medicEntity.getCrm())
                .speciality(medicEntity.getSpecialty())
                .openingHours(medicEntity.getOpeningHours())
                .build();
    }
}
