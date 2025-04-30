package com.br.infrastructure.service.gatewayImpl;

import com.br.application.gateway.MedicGateway;
import com.br.core.domain.Medic;
import com.br.core.enums.EnumCode;
import com.br.core.exceptions.MedicNotFound;
import com.br.infrastructure.dto.medic.MedicEntityFromJpaToMedic;
import com.br.infrastructure.dto.medic.MedicToJpa;
import com.br.infrastructure.entity.MedicEntity;
import com.br.infrastructure.repository.MedicEntityRepository;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class MedicGatewayImpl implements MedicGateway {

    private final MedicEntityRepository medicEntityRepository;

    public MedicGatewayImpl(MedicEntityRepository medicEntityRepository){
        this.medicEntityRepository = medicEntityRepository;
    }

    @Override
    public Medic saveMedic(Medic medic) {
        if(!medicEntityRepository.existsByCrm(medic.getCrm())){
            MedicEntity conversion = new MedicToJpa(medic).toJpa();
            MedicEntity medicSaved = medicEntityRepository.save(conversion);
            return new MedicEntityFromJpaToMedic(medicSaved).jpaToMedic();
        }
        throw new MedicNotFound(EnumCode.MED0002.getMessage());
    }

    @Override
    public List<Medic> findAll() {
        return medicEntityRepository
                .findAll().stream().map(m -> new MedicEntityFromJpaToMedic(m).jpaToMedic()).toList();
    }

    @Override
    public List<Medic> findByOpeningHours(LocalDateTime hour) {
        List<MedicEntity> medicEntityList = new ArrayList<>();
        for(MedicEntity medicEntity : medicEntityRepository.findAll())
            for(LocalDateTime hourS : medicEntity.getOpeningHours()){
                if(hourS.equals(hour)){
                    medicEntityList.add(medicEntity);
                }
            }
        return medicEntityList.stream().map(m -> new MedicEntityFromJpaToMedic(m).jpaToMedic()).toList();
    }

    @Override
    public Medic findById(Long id) {
        if(medicEntityRepository.existsById(id)){
            MedicEntity medicEntityDB = medicEntityRepository.getReferenceById(id);
            return new MedicEntityFromJpaToMedic(medicEntityDB).jpaToMedic();
        }
        throw new MedicNotFound(EnumCode.MED0000.getMessage());
    }

    @Override
    public Medic findByCrm(String crm) {
        if(medicEntityRepository.existsByCrm(crm)){
            MedicEntity medicEntityDB = medicEntityRepository.findByCrm(crm).get();
            return new MedicEntityFromJpaToMedic(medicEntityDB).jpaToMedic();
        }
        throw new MedicNotFound(EnumCode.MED0001.getMessage());
    }


    @Override
    public List<LocalDateTime> setOpeningHours(Medic medic, List<LocalDateTime> setOpeningHours) {
        if(medicEntityRepository.existsById(medic.getId())){
            MedicEntity medicDatabase = medicEntityRepository.getReferenceById(medic.getId());
            medicDatabase.setOpeningHours(setOpeningHours);
            medicEntityRepository.save(medicDatabase);
            return medicDatabase.getOpeningHours();
        }
        throw new MedicNotFound(EnumCode.MED0000.getMessage());
    }

    @Override
    public void deleteById(Long id) {
        if(medicEntityRepository.existsById(id)){
            medicEntityRepository.deleteById(id);
        }else{
            throw new MedicNotFound(EnumCode.MED0000.getMessage());
        }
    }
}
