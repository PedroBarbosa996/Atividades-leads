package com.example.atividade_leads.dto;

import java.util.UUID;

public class LeadResponse {

    private UUID id;
    private String nome;
    private String email;
    private String telefone;
    private String cpf;
    private Double consumoMedio;
    private String faixa;
    private Integer prioridade;
    private String sugestao;

    public LeadResponse() {
    }

    public LeadResponse(UUID id, String nome, String email, String telefone, String cpf, Double consumoMedio, String faixa, Integer prioridade, String sugestao) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.cpf = cpf;
        this.consumoMedio = consumoMedio;
        this.faixa = faixa;
        this.prioridade = prioridade;
        this.sugestao = sugestao;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Double getConsumoMedio() {
        return consumoMedio;
    }

    public void setConsumoMedio(Double consumoMedio) {
        this.consumoMedio = consumoMedio;
    }

    public String getFaixa() {
        return faixa;
    }

    public void setFaixa(String faixa) {
        this.faixa = faixa;
    }

    public Integer getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(Integer prioridade) {
        this.prioridade = prioridade;
    }

    public String getSugestao() {
        return sugestao;
    }

    public void setSugestao(String sugestao) {
        this.sugestao = sugestao;
    }
}
