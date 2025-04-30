package com.br.infrastructure.service.gatewayImpl;

import com.br.application.gateway.PatientGateway;
import com.br.core.domain.Patient;
import com.br.core.enums.EnumCode;
import com.br.core.exceptions.PatientConflict;
import com.br.core.exceptions.PatientNotFound;
import com.br.infrastructure.dto.patient.PatientEntityFromJpaToPatient;
import com.br.infrastructure.dto.patient.PatientToJpa;
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
        if(!existsByCpf(patient.getCpf()) && !patientEntityRepository.existsByNumberPhone(patient.getNumberPhone())){
            PatientEntity conversion = new PatientToJpa(patient).toJpa();
            PatientEntity patientSaved = patientEntityRepository.save(conversion);
            return new PatientEntityFromJpaToPatient(patientSaved).jpaToPatient();
        }
        throw new PatientConflict(EnumCode.PAT0002.getMessage());
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
        if(patientEntityRepository.existsById(patient.getId())){
            PatientEntity patientEntityDB = patientEntityRepository.getReferenceById(patient.getId());
            if(patient.getEmail() != null){
                patientEntityDB.setEmail(patient.getEmail());
            }
            if(patient.getNumberPhone() != null){
                patientEntityDB.setNumberPhone(patient.getNumberPhone());
            }
            PatientEntity patientSaved = patientEntityRepository.save(patientEntityDB);
            return new PatientEntityFromJpaToPatient(patientEntityDB).jpaToPatient();
        }
        throw new PatientNotFound(EnumCode.PAT0000.getMessage());
    }

    @Override
    public void deleteById(Long id) {
        if(existsById(id)){
            patientEntityRepository.deleteById(id);
        }else{
            throw new PatientNotFound(EnumCode.PAT0000.getMessage());
        }
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
