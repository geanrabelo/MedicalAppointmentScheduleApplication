package com.br.infrastructure.repository;

import com.br.infrastructure.entity.MedicEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicEntityRepository extends JpaRepository<MedicEntity, Long> {
}
