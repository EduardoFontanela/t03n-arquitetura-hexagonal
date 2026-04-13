package com.fag.lucasmartins.arquitetura_software.ecommerce.domain.model;

import com.fag.lucasmartins.arquitetura_software.ecommerce.domain.exception.DomainException;
import java.time.LocalDate;
import java.time.Period;
import java.util.UUID;

public class PessoaBO {

    private UUID id;
    private String nomeCompleto;
    private String cpf;
    private LocalDate dataNascimento;
    private String email;
    private String telefone;

    public PessoaBO(UUID id, String nomeCompleto, String cpf, LocalDate dataNascimento, String email, String telefone) {
        this.id = (id != null) ? id : UUID.randomUUID();
        this.nomeCompleto = nomeCompleto;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.email = email;
        this.telefone = telefone;
        
        validar();
    }

    private void validar() {
        if (this.cpf == null || this.cpf.length() != 11) {
            throw new DomainException("O CPF deve ser obrigatório e possuir exatamente 11 caracteres.");
        }
        
        if (this.telefone == null || this.telefone.length() != 11) {
            throw new DomainException("O telefone deve possuir exatamente 11 caracteres.");
        }
        
        if (this.email == null || !this.email.contains("@")) {
            throw new DomainException("O e-mail é obrigatório e deve conter '@'.");
        }
        
        if (this.dataNascimento == null || Period.between(this.dataNascimento, LocalDate.now()).getYears() < 18) {
            throw new DomainException("O cliente deve ter no mínimo 18 anos.");
        }
    }

    public UUID getId() { return id; }
    public String getNomeCompleto() { return nomeCompleto; }
    public String getCpf() { return cpf; }
    public LocalDate getDataNascimento() { return dataNascimento; }
    public String getEmail() { return email; }
    public String getTelefone() { return telefone; }
}