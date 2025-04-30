package com.br.infrastructure.service.servicesImpl;

import com.br.infrastructure.dto.MedicCreationDTO;
import com.br.infrastructure.dto.MedicDetailsDTO;
import com.br.infrastructure.service.interfaces.MedicService;
import com.br.usecases.MedicUsecases;

import java.time.LocalDateTime;
import java.util.List;

public class MedicServiceImpl implements MedicService {

    private final MedicUsecases medicUsecases;

    public MedicServiceImpl(MedicUsecases medicUsecases){
        this.medicUsecases = medicUsecases;
    }

    @Override
    public String saveMedic(MedicCreationDTO medicCreationDTO) {
        return "";
    }

    @Override
    public List<MedicDetailsDTO> findAll() {
        return List.of();
    }

    @Override
    public List<MedicDetailsDTO> findByOpeningHours(LocalDateTime hour) {
        return List.of();
    }

    @Override
    public MedicDetailsDTO findById(Long id) {
        return null;
    }

    @Override
    public MedicDetailsDTO findByCrm(String crm) {
        return null;
    }

    @Override
    public String setOpeningHours(Long medicId, List<LocalDateTime> openingHours) {
        return "";
    }

    @Override
    public void deleteById(Long id) {

    }
}
