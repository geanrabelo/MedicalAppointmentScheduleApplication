package com.br.infrastructure.entity;

import com.br.core.enums.Specialty;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "tb_medic")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@EqualsAndHashCode(of = "id")
public class MedicEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String crm;

    @Enumerated(EnumType.STRING)
    private Specialty specialty;
    private List<LocalDateTime> openingHours;
}
