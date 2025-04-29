package com.br.infrastructure.repository;

import com.br.infrastructure.entity.PatientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientEntityRepository extends JpaRepository<PatientEntity, Long> {
}
