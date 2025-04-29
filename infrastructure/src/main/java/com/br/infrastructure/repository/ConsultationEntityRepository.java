package com.br.infrastructure.repository;

import com.br.infrastructure.entity.ConsultationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultationEntityRepository extends JpaRepository<ConsultationEntity, String> {
}
