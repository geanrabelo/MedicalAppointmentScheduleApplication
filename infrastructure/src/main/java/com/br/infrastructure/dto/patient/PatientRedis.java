package com.br.infrastructure.dto.patient;

import java.time.LocalDate;

public record PatientRedis(Long id,
                           String name,
                           String cpf,
                           String email,
                           String numberPhone,
                           LocalDate dateOfBirth) {


}
