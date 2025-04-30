package com.br.infrastructure.dto.medic;

import com.br.core.enums.Specialty;

import java.time.LocalDateTime;
import java.util.List;

public record MedicDetailsDTO(Long id,
                              String name,
                              String crm,
                              Specialty specialty,
                              List<LocalDateTime> openingHours) {

}
