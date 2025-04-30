package com.br.infrastructure.service.gatewayImpl;

import com.br.application.gateway.PatientGateway;
import com.br.core.domain.Patient;
import com.br.core.enums.EnumCode;
import com.br.core.exceptions.PatientNotFound;
import com.br.infrastructure.dto.patient.PatientEntityFromJpaToPatient;
import com.br.infrastructure.entity.PatientEntity;
import com.br.infrastructure.repository.PatientEntityRepository;
import com.br.usecases.PatientUsecases;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PatientGatewayImpl implements PatientGateway {

    private final PatientEntityRepository patientEntityRepository;

    public PatientGatewayImpl(PatientEntityRepository patientEntityRepository){
        this.patientEntityRepository = patientEntityRepository;
    }

    @Override
    public Patient savePatient(Patient patient) {

    }

    @Override
    public List<Patient> findAll() {
        return patientEntityRepository.findAll()
                .stream().map(p -> new PatientEntityFromJpaToPatient(p).jpaToPatient()).toList();
    }

    @Override
    public Patient findById(Long id) {
        if(existsById(id)){
            PatientEntity patientEntityDB = patientEntityRepository.getReferenceById(id);
            return new PatientEntityFromJpaToPatient(patientEntityDB).jpaToPatient();
        }
        throw new PatientNotFound(EnumCode.PAT0001.getMessage());
    }

    @Override
    public Patient findByCpf(String cpf) {
        if(existsByCpf(cpf)){
            PatientEntity patientEntityDB = patientEntityRepository.findByCpf(cpf).get();
            return new PatientEntityFromJpaToPatient(patientEntityDB).jpaToPatient();
        }
        throw new PatientNotFound(EnumCode.PAT0001.getMessage());
    }

    @Override
    public Patient update(Patient patient) {

    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public boolean existsById(Long id) {
        return patientEntityRepository.existsById(id);
    }

    @Override
    public boolean existsByCpf(String cpf) {
        return patientEntityRepository.existsByCpf(cpf);
    }
}
