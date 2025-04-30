package com.br.application.gateway;

import com.br.core.domain.Medic;

import java.time.LocalDateTime;
import java.util.List;

public interface MedicGateway {

    Medic saveMedic(Medic medic);

    List<Medic> findAll();

    List<Medic> findByOpeningHours(LocalDateTime hour);

    Medic findById(Long id);

    Medic findByCrm(String crm);

    List<LocalDateTime> setOpeningHours(Medic medic, List<LocalDateTime> setOpeningHours);

    void deleteById(Long id);

}
