package com.br.infrastructure.dto;

import java.time.LocalDateTime;

public record ConsultationCreationDTO(Long patient_id,
                                      Long medic_id,
                                      LocalDateTime hour) {
}
