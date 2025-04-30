package com.br.infrastructure.service.gatewayImpl;

import com.br.application.gateway.MedicGateway;
import com.br.core.domain.Medic;
import com.br.infrastructure.repository.MedicEntityRepository;
import com.br.usecases.MedicUsecases;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class MedicGatewayImpl implements MedicGateway {

    private final MedicEntityRepository medicEntityRepository;

    public MedicGatewayImpl(MedicEntityRepository medicEntityRepository){
        this.medicEntityRepository = medicEntityRepository;
    }

    @Override
    public Medic saveMedic(Medic medic) {

    }

    @Override
    public List<Medic> findAll() {

    }

    @Override
    public List<Medic> findByOpeningHours(LocalDateTime hour) {

    }

    @Override
    public Medic findById(Long id) {

    }

    @Override
    public Medic findByCrm(String crm) {

    }


    @Override
    public List<LocalDateTime> setOpeningHours(Medic medic, List<LocalDateTime> setOpeningHours) {

    }

    @Override
    public void deleteById(Long id) {

    }
}
