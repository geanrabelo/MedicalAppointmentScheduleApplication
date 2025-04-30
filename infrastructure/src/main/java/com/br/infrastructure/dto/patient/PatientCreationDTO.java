package com.br.infrastructure.dto.patient;

import java.time.LocalDate;

public record PatientCreationDTO(String name,
                                 String cpf,
                                 String email,
                                 String numberPhone,
                                 LocalDate dateOfBirth) {

}
