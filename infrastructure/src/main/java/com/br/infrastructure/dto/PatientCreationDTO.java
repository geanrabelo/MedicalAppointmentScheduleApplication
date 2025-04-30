package com.br.infrastructure.dto;

import java.time.LocalDate;

public record PatientCreationDTO(String name,
                                 String cpf,
                                 String email,
                                 String numberPhone,
                                 LocalDate dateOfBirth) {

}
