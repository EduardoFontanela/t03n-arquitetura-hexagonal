package com.fag.lucasmartins.arquitetura_software.ecommerce.infrastructure.adapters.in.web;

import com.fag.lucasmartins.arquitetura_software.ecommerce.application.services.PessoaService;
import com.fag.lucasmartins.arquitetura_software.ecommerce.domain.model.PessoaBO;
import com.fag.lucasmartins.arquitetura_software.ecommerce.infrastructure.adapters.in.web.dto.PessoaRequestDTO;
import com.fag.lucasmartins.arquitetura_software.ecommerce.infrastructure.adapters.in.web.dto.PessoaResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pessoas")
public class PessoaControllerAdapter {

    private final PessoaService pessoaService;

    public PessoaControllerAdapter(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }

    @PostMapping
    public ResponseEntity<PessoaResponseDTO> cadastrar(@RequestBody PessoaRequestDTO dto) {
        PessoaBO pessoaBO = new PessoaBO(
                null,
                dto.getNomeCompleto(),
                dto.getCpf(),
                dto.getDataNascimento(),
                dto.getEmail(),
                dto.getTelefone()
        );

        PessoaBO pessoaSalva = pessoaService.cadastrarPessoa(pessoaBO);

        return ResponseEntity.status(HttpStatus.CREATED).body(PessoaResponseDTO.fromDomain(pessoaSalva));
    }
}