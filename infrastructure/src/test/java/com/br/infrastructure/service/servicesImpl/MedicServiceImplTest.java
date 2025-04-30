package com.br.infrastructure.service.servicesImpl;

import com.br.core.domain.Medic;
import com.br.core.enums.Specialty;
import com.br.infrastructure.dto.medic.MedicCreationDTO;
import com.br.infrastructure.dto.medic.MedicDetailsDTO;
import com.br.usecases.MedicUsecases;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class MedicServiceImplTest {

    @InjectMocks
    private MedicServiceImpl medicServiceImpl;

    @Mock
    private MedicUsecases medicUsecases;

    private MedicCreationDTO medicCreationDTO;

    private Medic medic;

    private MedicDetailsDTO medicDetailsDTO;

    private final static Long id = 1L;
    private final static String name = "GEAN";
    private final static String crm = "152323541";
    private final static Specialty specialty = Specialty.NEUROLOGY;
    private final static LocalDateTime hour = LocalDateTime.now();
    private final static List<LocalDateTime> openingHours = List.of(hour);

    @BeforeEach
    void startBefore(){
        startMedic();
    }

    @Test
    void whenSaveMedicSuccessfully() {
        Mockito.when(medicUsecases.saveMedic(Mockito.any())).thenReturn(medic);

        medicServiceImpl.saveMedic(medicCreationDTO);
        Assertions.assertEquals(medic.getName(), medicCreationDTO.name());
    }

    @Test
    void whenFindAllSuccessfully() {
        Mockito.when(medicUsecases.findAll()).thenReturn(List.of(new Medic(id, name, crm, specialty, openingHours)));

        List<MedicDetailsDTO> response = medicServiceImpl.findAll();

        Assertions.assertEquals(response.size(), 1);
    }

    @Test
    void whenFindByOpeningHoursSuccessfully() {
        Mockito.when(medicUsecases.findByOpeningHours(Mockito.any())).thenReturn(List.of(new Medic(id, name, crm, specialty, openingHours)));

        List<MedicDetailsDTO> response = medicServiceImpl.findByOpeningHours(hour);

        Assertions.assertEquals(response.size(), openingHours.size());

    }

    @Test
    void whenFindByIdWithSuccessfully() {
        Mockito.when(medicUsecases.findById(Mockito.any())).thenReturn(medic);

        MedicDetailsDTO response = medicServiceImpl.findById(id);

        Assertions.assertEquals(response.name(), medic.getName());
        Assertions.assertEquals(response.id(), medic.getId());
        Assertions.assertEquals(response.specialty(), medic.getSpecialty());
    }

    @Test
    void whenFindByCrmWithSuccessfully() {
        Mockito.when(medicUsecases.findByCrm(Mockito.any())).thenReturn(medic);

        MedicDetailsDTO response = medicServiceImpl.findByCrm(crm);

        Assertions.assertEquals(response.name(), medic.getName());
        Assertions.assertEquals(response.id(), medic.getId());
        Assertions.assertEquals(response.specialty(), medic.getSpecialty());
    }

    @Test
    void whenDeleteByIdWithSuccessfully() {
        Mockito.doNothing().when(medicUsecases).deleteById(id);

        medicServiceImpl.deleteById(id);

    }

    private void startMedic(){
        medicCreationDTO = new MedicCreationDTO(name, crm, specialty);
        medicDetailsDTO = new MedicDetailsDTO(id, name, crm, specialty, openingHours);
        medic = new Medic(id, name, crm, specialty, openingHours);
    }
}