package com.br.infrastructure.entity;

import com.br.core.enums.Status;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "tb_consultation")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@EqualsAndHashCode(of = "id")
public class ConsultationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private PatientEntity patientEntity;

    @ManyToOne
    @JoinColumn(name = "medic_id")
    private MedicEntity medicEntity;

    private LocalDateTime hour;

    @Enumerated(EnumType.STRING)
    private Status status;

    private String reasonCancellation;
}
