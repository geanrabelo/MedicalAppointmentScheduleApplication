package com.br.usecases;

import com.br.core.domain.Patient;

import java.util.List;

public interface PatientUsecases {

    Patient savePatient(Patient patient);

    List<Patient> findAll();

    Patient findById(Long id);

    Patient findByCpf(String cpf);

    Patient update(Patient patient);

    void deleteById(Long id);

    boolean existsById(Long id);

    boolean existsByCpf(String cpf);

}
