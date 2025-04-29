package com.br.usecases;

import com.br.core.domain.Medic;

import java.time.LocalDateTime;
import java.util.List;

public interface MedicUsecases {

    Medic saveMedic(Medic medic);

    List<Medic> findAll();

    List<Medic> findByOpeningHours(LocalDateTime hour);

    Medic findById(Long id);

    Medic findByCrm(String crm);

    List<LocalDateTime> setOpeningHours(List<LocalDateTime> setOpeningHours);

    void deleteById(Long id);
}
