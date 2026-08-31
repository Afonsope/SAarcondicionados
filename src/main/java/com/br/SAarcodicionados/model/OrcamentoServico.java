package com.br.SAarcodicionados.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "orcamento_servico")
@IdClass(OrcamentoServicoId.class)
public class OrcamentoServico {

    @Id
    @Column(name = "id_orcamento")
    private Integer idOrcamento;

    @Id
    @Column(name = "id_servico")
    private Integer idServico;

    @Column(name = "valor_cobrado", nullable = false)
    private BigDecimal valorCobrado;

    @Column(name = "quantidade", nullable = false)
    private Integer quantidade;

    // Getters and Setters

    public Integer getIdOrcamento() {
        return idOrcamento;
    }

    public void setIdOrcamento(Integer idOrcamento) {
        this.idOrcamento = idOrcamento;
    }

    public Integer getIdServico() {
        return idServico;
    }

    public void setIdServico(Integer idServico) {
        this.idServico = idServico;
    }

    public BigDecimal getValorCobrado() {
        return valorCobrado;
    }

    public void setValorCobrado(BigDecimal valorCobrado) {
        this.valorCobrado = valorCobrado;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
}