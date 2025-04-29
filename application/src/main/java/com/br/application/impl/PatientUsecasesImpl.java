package com.br.application.impl;

import com.br.application.gateway.PatientGateway;
import com.br.core.domain.Patient;
import com.br.usecases.PatientUsecases;

import java.util.List;

public class PatientUsecasesImpl implements PatientUsecases {

    private final PatientGateway patientGateway;

    public PatientUsecasesImpl(PatientGateway patientGateway){
        this.patientGateway = patientGateway;
    }

    @Override
    public Patient savePatient(Patient patient) {
        return patientGateway.savePatient(patient);
    }

    @Override
    public List<Patient> findAll() {
        return patientGateway.findAll();
    }

    @Override
    public Patient findById(Long id) {
        return patientGateway.findById(id);
    }

    @Override
    public Patient findByCpf(String cpf) {
        return patientGateway.findByCpf(cpf);
    }

    @Override
    public Patient update(Patient patient) {
        return patientGateway.update(patient);
    }

    @Override
    public void deleteById(Long id) {
        patientGateway.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return patientGateway.existsById(id);
    }

    @Override
    public boolean existsByCpf(String cpf) {
        return patientGateway.existsByCpf(cpf);
    }
}
