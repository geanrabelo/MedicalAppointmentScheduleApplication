package com.br.infrastructure.service.gatewayImpl;

import com.br.application.gateway.PatientGateway;
import com.br.core.domain.Patient;
import com.br.usecases.PatientUsecases;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PatientGatewayImpl implements PatientGateway {


    @Override
    public Patient savePatient(Patient patient) {

    }

    @Override
    public List<Patient> findAll() {

    }

    @Override
    public Patient findById(Long id) {

    }

    @Override
    public Patient findByCpf(String cpf) {

    }

    @Override
    public Patient update(Patient patient) {

    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public boolean existsById(Long id) {
    }

    @Override
    public boolean existsByCpf(String cpf) {

    }
}
