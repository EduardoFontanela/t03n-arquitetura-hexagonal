package com.fag.lucasmartins.arquitetura_software.ecommerce.application.ports.out;

import com.fag.lucasmartins.arquitetura_software.ecommerce.domain.model.PessoaBO;

public interface PessoaServicePort {
    PessoaBO salvar(PessoaBO pessoaBO);
}