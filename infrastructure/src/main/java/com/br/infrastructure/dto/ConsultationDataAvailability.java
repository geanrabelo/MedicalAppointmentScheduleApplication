package com.br.infrastructure.dto;

import com.br.core.enums.Specialty;

import java.time.LocalDate;

public record ConsultationDataAvailability(Specialty specialty,
                                           LocalDate localDate) {
}
