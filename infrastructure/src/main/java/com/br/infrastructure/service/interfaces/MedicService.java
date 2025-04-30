package com.br.infrastructure.service.interfaces;

import com.br.infrastructure.dto.MedicCreationDTO;
import com.br.infrastructure.dto.MedicDetailsDTO;

import java.time.LocalDateTime;
import java.util.List;

public interface MedicService {

    String saveMedic(MedicCreationDTO medicCreationDTO);

    List<MedicDetailsDTO> findAll();

    List<MedicDetailsDTO> findByOpeningHours(LocalDateTime hour);

    MedicDetailsDTO findById(Long id);

    MedicDetailsDTO findByCrm(String crm);

    String setOpeningHours(Long medicId, List<LocalDateTime> openingHours);

    void deleteById(Long id);
}
