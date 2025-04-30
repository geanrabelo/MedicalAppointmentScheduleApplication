package com.br.infrastructure.dto.consultation;

import java.time.LocalDateTime;

public record ConsultationCancelDTO(Long patient_id,
                                    Long medic_id,
                                    LocalDateTime hour,
                                    String reason) {
}
