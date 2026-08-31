package com.br.SAarcodicionados.model;

import javax.persistence.*;

@Entity
@Table(name = "tipo_pagamento")
public class TipoPagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTipoPagamento;

    @Column(name = "descricao", nullable = false, unique = true)
    private String descricao;

    // Getters and Setters
    public Long getIdTipoPagamento() {
        return idTipoPagamento;
    }

    public void setIdTipoPagamento(Long idTipoPagamento) {
        this.idTipoPagamento = idTipoPagamento;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}