package com.br.infrastructure.service.servicesImpl;

import com.br.core.domain.Patient;
import com.br.infrastructure.dto.patient.PatientCreationDTO;
import com.br.infrastructure.dto.patient.PatientDetailsDTO;
import com.br.infrastructure.dto.patient.PatientUpdateDTO;
import com.br.infrastructure.service.interfaces.PatientService;
import com.br.usecases.PatientUsecases;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {

    private final PatientUsecases patientUsecases;

    public PatientServiceImpl(PatientUsecases patientUsecases){
        this.patientUsecases = patientUsecases;
    }

    @Override
    public String savePatient(PatientCreationDTO patientCreationDTO) {
        Patient patient = patientCreationDTO.toPatient();
        Patient patientSaved = patientUsecases.savePatient(patient);
        return "Patient: "+ patientSaved.getName() +" saved successfully";
    }

    @Override
    public List<PatientDetailsDTO> findAll() {
        return patientUsecases.findAll().stream().map(PatientDetailsDTO::new).toList();
    }

    @Override
    public PatientDetailsDTO findById(Long id) {
        Patient patient = patientUsecases.findById(id);
        return new PatientDetailsDTO(patient);
    }

    @Override
    public PatientDetailsDTO findByCpf(String cpf) {
        Patient patient = patientUsecases.findByCpf(cpf);
        return new PatientDetailsDTO(patient);
    }

    @Override
    public PatientDetailsDTO update(PatientUpdateDTO patientUpdateDTO) {
        Patient patient = patientUpdateDTO.toPatient();
        Patient patientUpdated = patientUsecases.update(patient);
        return new PatientDetailsDTO(patientUpdated);
    }

    @Override
    public void deleteById(Long id) {
        patientUsecases.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return patientUsecases.existsById(id);
    }

    @Override
    public boolean existsByCpf(String cpf) {
        return patientUsecases.existsByCpf(cpf);
    }
}
