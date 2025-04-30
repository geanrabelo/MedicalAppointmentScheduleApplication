package com.br.infrastructure.dto.medic;

import java.time.LocalDateTime;
import java.util.List;

public record MedicOpeningHoursDTO(Long id, List<LocalDateTime> openingHours) {
}
