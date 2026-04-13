package com.fag.lucasmartins.arquitetura_software.ecommerce.infrastructure.adapters.out.persistence;

import com.fag.lucasmartins.arquitetura_software.ecommerce.application.ports.out.PessoaServicePort;
import com.fag.lucasmartins.arquitetura_software.ecommerce.domain.model.PessoaBO;
import com.fag.lucasmartins.arquitetura_software.ecommerce.infrastructure.adapters.out.persistence.entities.PessoaEntity;
import org.springframework.stereotype.Component;

@Component
public class PessoaRepositoryAdapter implements PessoaServicePort {

    private final PessoaJpaRepository pessoaJpaRepository;

    public PessoaRepositoryAdapter(PessoaJpaRepository pessoaJpaRepository) {
        this.pessoaJpaRepository = pessoaJpaRepository;
    }

    @Override
    public PessoaBO salvar(PessoaBO pessoaBO) {
        PessoaEntity entity = new PessoaEntity(
                pessoaBO.getId(),
                pessoaBO.getNomeCompleto(),
                pessoaBO.getCpf(),
                pessoaBO.getDataNascimento(),
                pessoaBO.getEmail(),
                pessoaBO.getTelefone()
        );

        PessoaEntity entidadeSalva = pessoaJpaRepository.save(entity);

        return new PessoaBO(
                entidadeSalva.getId(),
                entidadeSalva.getNomeCompleto(),
                entidadeSalva.getCpf(),
                entidadeSalva.getDataNascimento(),
                entidadeSalva.getEmail(),
                entidadeSalva.getTelefone()
        );
    }
}