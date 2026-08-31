package com.br.SAarcodicionados.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "parcela")
public class Parcela {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_parcela;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "id_pagamento", nullable = false)
    private Pagamento pagamento;

    @NotNull
    private Integer numero_parcela;

    @NotNull
    private Double valor_parcela;

    @NotNull
    @Temporal(TemporalType.DATE)
    private Date data_vencimento;

    @Temporal(TemporalType.DATE)
    private Date data_pagamento;

    @NotNull
    private String status;

    // Getters and Setters

    public Long getId_parcela() {
        return id_parcela;
    }

    public void setId_parcela(Long id_parcela) {
        this.id_parcela = id_parcela;
    }

    public Pagamento getPagamento() {
        return pagamento;
    }

    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }

    public Integer getNumero_parcela() {
        return numero_parcela;
    }

    public void setNumero_parcela(Integer numero_parcela) {
        this.numero_parcela = numero_parcela;
    }

    public Double getValor_parcela() {
        return valor_parcela;
    }

    public void setValor_parcela(Double valor_parcela) {
        this.valor_parcela = valor_parcela;
    }

    public Date getData_vencimento() {
        return data_vencimento;
    }

    public void setData_vencimento(Date data_vencimento) {
        this.data_vencimento = data_vencimento;
    }

    public Date getData_pagamento() {
        return data_pagamento;
    }

    public void setData_pagamento(Date data_pagamento) {
        this.data_pagamento = data_pagamento;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}