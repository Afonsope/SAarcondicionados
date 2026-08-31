package com.br.SAarcodicionados.dto;

import java.util.Date;

public class OsDto {
    private Long idOs;
    private Long idCliente;
    private Long idFuncionario;
    private Long idTipoOs;
    private Long idClienteEquipamento;
    private Long idOrcamento;
    private Date dataAbertura;
    private Date dataAgendada;
    private Date dataConclusao;
    private String status;
    private String descricaoProblema;
    private String observacoes;
    private Double valorTotal;

    // Getters and Setters

    public Long getIdOs() {
        return idOs;
    }

    public void setIdOs(Long idOs) {
        this.idOs = idOs;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public Long getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(Long idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public Long getIdTipoOs() {
        return idTipoOs;
    }

    public void setIdTipoOs(Long idTipoOs) {
        this.idTipoOs = idTipoOs;
    }

    public Long getIdClienteEquipamento() {
        return idClienteEquipamento;
    }

    public void setIdClienteEquipamento(Long idClienteEquipamento) {
        this.idClienteEquipamento = idClienteEquipamento;
    }

    public Long getIdOrcamento() {
        return idOrcamento;
    }

    public void setIdOrcamento(Long idOrcamento) {
        this.idOrcamento = idOrcamento;
    }

    public Date getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(Date dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public Date getDataAgendada() {
        return dataAgendada;
    }

    public void setDataAgendada(Date dataAgendada) {
        this.dataAgendada = dataAgendada;
    }

    public Date getDataConclusao() {
        return dataConclusao;
    }

    public void setDataConclusao(Date dataConclusao) {
        this.dataConclusao = dataConclusao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescricaoProblema() {
        return descricaoProblema;
    }

    public void setDescricaoProblema(String descricaoProblema) {
        this.descricaoProblema = descricaoProblema;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }
}