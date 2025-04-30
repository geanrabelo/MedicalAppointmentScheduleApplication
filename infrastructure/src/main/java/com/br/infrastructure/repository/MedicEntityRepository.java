package com.br.infrastructure.repository;

import com.br.infrastructure.entity.MedicEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MedicEntityRepository extends JpaRepository<MedicEntity, Long> {

    Optional<MedicEntity> findByCrm(String crm);
}
