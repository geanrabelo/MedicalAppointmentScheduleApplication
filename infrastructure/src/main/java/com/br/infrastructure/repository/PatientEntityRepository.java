package com.br.infrastructure.repository;

import com.br.infrastructure.entity.PatientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PatientEntityRepository extends JpaRepository<PatientEntity, Long> {

    boolean existsByCpf(String cpf);

    Optional<PatientEntity> findByCpf(String cpf);
}
