package com.br.infrastructure.service.interfaces;

import com.br.infrastructure.dto.patient.PatientCreationDTO;
import com.br.infrastructure.dto.patient.PatientDetailsDTO;
import com.br.infrastructure.dto.patient.PatientUpdateDTO;

import java.util.List;

public interface PatientService {

    String savePatient(PatientCreationDTO patientCreationDTO);

    List<PatientDetailsDTO> findAll();

    PatientDetailsDTO findById(Long id);

    PatientDetailsDTO findByCpf(String cpf);

    PatientDetailsDTO update(PatientUpdateDTO patientUpdateDTO);

    void deleteById(Long id);

    boolean existsById(Long id);

    boolean existsByCpf(String cpf);

}
