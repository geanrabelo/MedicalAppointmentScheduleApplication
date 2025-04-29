package com.br.application.impl;

import com.br.application.gateway.MedicGateway;
import com.br.core.domain.Medic;
import com.br.usecases.MedicUsecases;

import java.time.LocalDateTime;
import java.util.List;

public class MedicUsecasesImpl implements MedicUsecases {

    private final MedicGateway medicGateway;

    public MedicUsecasesImpl(MedicGateway medicGateway){
        this.medicGateway = medicGateway;
    }

    @Override
    public Medic saveMedic(Medic medic) {
        return medicGateway.saveMedic(medic);
    }

    @Override
    public List<Medic> findAll() {
        return medicGateway.findAll();
    }

    @Override
    public List<Medic> findByOpeningHours(LocalDateTime hour) {
        return medicGateway.findByOpeningHours(hour);
    }

    @Override
    public Medic findById(Long id) {
        return medicGateway.findById(id);
    }

    @Override
    public Medic findByCrm(String crm) {
        return medicGateway.findByCrm(crm);
    }

    @Override
    public List<LocalDateTime> setOpeningHours(List<LocalDateTime> setOpeningHours) {
        return medicGateway.setOpeningHours(setOpeningHours);
    }

    @Override
    public void deleteById(Long id) {
        medicGateway.deleteById(id);
    }
}
