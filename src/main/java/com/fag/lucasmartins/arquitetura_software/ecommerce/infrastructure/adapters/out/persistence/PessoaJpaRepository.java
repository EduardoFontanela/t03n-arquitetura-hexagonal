package com.fag.lucasmartins.arquitetura_software.ecommerce.infrastructure.adapters.out.persistence;

import com.fag.lucasmartins.arquitetura_software.ecommerce.infrastructure.adapters.out.persistence.entities.PessoaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface PessoaJpaRepository extends JpaRepository<PessoaEntity, UUID> {
}