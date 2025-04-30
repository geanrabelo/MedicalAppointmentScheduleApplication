package com.br.infrastructure.dto.medic;

import com.br.core.enums.Specialty;

public record MedicCreationDTO(String name,
                               String cpf,
                               Specialty specialty) {
}
