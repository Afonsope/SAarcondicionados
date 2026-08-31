package com.br.SAarcodicionados.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "servico")
public class Servico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_servico;

    @NotNull
    @Column(name = "nome_servico")
    private String nomeServico;

    @Column(name = "descricao")
    private String descricao;

    @NotNull
    @Column(name = "valor_base")
    private Double valorBase;

    @Column(name = "duracao_estimada_min")
    private Integer duracaoEstimadaMin;

    // Getters and Setters

    public Long getId_servico() {
        return id_servico;
    }

    public void setId_servico(Long id_servico) {
        this.id_servico = id_servico;
    }

    public String getNomeServico() {
        return nomeServico;
    }

    public void setNomeServico(String nomeServico) {
        this.nomeServico = nomeServico;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getValorBase() {
        return valorBase;
    }

    public void setValorBase(Double valorBase) {
        this.valorBase = valorBase;
    }

    public Integer getDuracaoEstimadaMin() {
        return duracaoEstimadaMin;
    }

    public void setDuracaoEstimadaMin(Integer duracaoEstimadaMin) {
        this.duracaoEstimadaMin = duracaoEstimadaMin;
    }
}