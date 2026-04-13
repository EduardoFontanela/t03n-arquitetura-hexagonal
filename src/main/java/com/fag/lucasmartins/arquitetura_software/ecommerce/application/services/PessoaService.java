package com.fag.lucasmartins.arquitetura_software.ecommerce.application.services;

import com.fag.lucasmartins.arquitetura_software.ecommerce.application.ports.out.PessoaServicePort;
import com.fag.lucasmartins.arquitetura_software.ecommerce.domain.model.PessoaBO;
import org.springframework.stereotype.Service;

@Service
public class PessoaService {

    private final PessoaServicePort pessoaServicePort;

    public PessoaService(PessoaServicePort pessoaServicePort) {
        this.pessoaServicePort = pessoaServicePort;
    }

    public PessoaBO cadastrarPessoa(PessoaBO pessoaBO) {
        return pessoaServicePort.salvar(pessoaBO);
    }
}