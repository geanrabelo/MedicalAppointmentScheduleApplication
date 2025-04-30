package com.br.infrastructure.entity;

import com.br.core.enums.Specialty;
import com.fasterxml.jackson.annotation.JsonFormat;
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

    @ElementCollection
    @CollectionTable(name = "doctor_opening_hours", joinColumns = @JoinColumn(name = "doctor_id"))
    @Column(name = "opening_time")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private List<LocalDateTime> openingHours;
}
