package com.br.SAarcodicionados.model;

import javax.persistence.*;

@Entity
@Table(name = "os_servico")
public class OsServico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idOsServico;

    @ManyToOne
    @JoinColumn(name = "id_os", nullable = false)
    private Os os;

    @ManyToOne
    @JoinColumn(name = "id_servico", nullable = false)
    private Servico servico;

    private Double valorCobrado;
    private Integer quantidade;

    // Getters and Setters

    public Long getIdOsServico() {
        return idOsServico;
    }

    public void setIdOsServico(Long idOsServico) {
        this.idOsServico = idOsServico;
    }

    public Os getOs() {
        return os;
    }

    public void setOs(Os os) {
        this.os = os;
    }

    public Servico getServico() {
        return servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }

    public Double getValorCobrado() {
        return valorCobrado;
    }

    public void setValorCobrado(Double valorCobrado) {
        this.valorCobrado = valorCobrado;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
}