package com.br.infrastructure.service.servicesImpl;

import com.br.core.domain.Medic;
import com.br.infrastructure.dto.medic.MedicCreationDTO;
import com.br.infrastructure.dto.medic.MedicDetailsDTO;
import com.br.infrastructure.service.interfaces.MedicService;
import com.br.usecases.MedicUsecases;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class MedicServiceImpl implements MedicService {

    private final MedicUsecases medicUsecases;

    public MedicServiceImpl(MedicUsecases medicUsecases){
        this.medicUsecases = medicUsecases;
    }

    @Override
    public String saveMedic(MedicCreationDTO medicCreationDTO) {
        Medic medic = medicCreationDTO.toMedic();
        Medic medicSaved = medicUsecases.saveMedic(medic);
        return "Medic "+ medicSaved.getName() +" saved successfully";
    }

    @Override
    public List<MedicDetailsDTO> findAll() {
        List<Medic> medicList = medicUsecases.findAll();
        return medicList.stream().map(MedicDetailsDTO::new).toList();
    }

    @Override
    public List<MedicDetailsDTO> findByOpeningHours(LocalDateTime hour) {
        return medicUsecases.findByOpeningHours(hour).stream()
                .map(MedicDetailsDTO::new).toList();
    }

    @Override
    public MedicDetailsDTO findById(Long id) {
        Medic medic = medicUsecases.findById(id);
        return new MedicDetailsDTO(medic);
    }

    @Override
    public MedicDetailsDTO findByCrm(String crm) {
        Medic medic = medicUsecases.findByCrm(crm);
        return new MedicDetailsDTO(medic);
    }

    @Override
    public String setOpeningHours(Long medicId, List<LocalDateTime> openingHours) {
        MedicDetailsDTO medicDetailsDTO = findById(medicId);
        Medic medic = new Medic.MedicBuilder()
                .builder()
                .id(medicDetailsDTO.id())
                .name(medicDetailsDTO.name())
                .crm(medicDetailsDTO.crm())
                .speciality(medicDetailsDTO.specialty())
                .openingHours(medicDetailsDTO.openingHours())
                .build();
        medicUsecases.setOpeningHours(medic, openingHours);
        return "OpeningHours updated successfully";
    }

    @Override
    public void deleteById(Long id) {
        medicUsecases.deleteById(id);
    }
}
