package com.br.SAarcodicionados.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Table(name = "os")
public class Os {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idOs;

    @ManyToOne
    @JoinColumn(name = "id_cliente", nullable = false)
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "id_funcionario", nullable = false)
    private Funcionario funcionario;

    @ManyToOne
    @JoinColumn(name = "id_tipo_os", nullable = false)
    private TipoOs tipoOs;

    @ManyToOne
    @JoinColumn(name = "id_cliente_equipamento")
    private ClienteEquipamento clienteEquipamento;

    @ManyToOne
    @JoinColumn(name = "id_orcamento")
    private Orcamento orcamento;

    @Column(name = "data_abertura", nullable = false)
    private Timestamp dataAbertura;

    @Column(name = "data_agendada")
    private Timestamp dataAgendada;

    @Column(name = "data_conclusao")
    private Timestamp dataConclusao;

    @Column(name = "status", nullable = false)
    private String status;

    @Column(name = "descricao_problema")
    private String descricaoProblema;

    @Column(name = "observacoes")
    private String observacoes;

    @Column(name = "valor_total", nullable = false)
    private BigDecimal valorTotal;

    // Getters and Setters

    public Long getIdOs() {
        return idOs;
    }

    public void setIdOs(Long idOs) {
        this.idOs = idOs;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public TipoOs getTipoOs() {
        return tipoOs;
    }

    public void setTipoOs(TipoOs tipoOs) {
        this.tipoOs = tipoOs;
    }

    public ClienteEquipamento getClienteEquipamento() {
        return clienteEquipamento;
    }

    public void setClienteEquipamento(ClienteEquipamento clienteEquipamento) {
        this.clienteEquipamento = clienteEquipamento;
    }

    public Orcamento getOrcamento() {
        return orcamento;
    }

    public void setOrcamento(Orcamento orcamento) {
        this.orcamento = orcamento;
    }

    public Timestamp getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(Timestamp dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public Timestamp getDataAgendada() {
        return dataAgendada;
    }

    public void setDataAgendada(Timestamp dataAgendada) {
        this.dataAgendada = dataAgendada;
    }

    public Timestamp getDataConclusao() {
        return dataConclusao;
    }

    public void setDataConclusao(Timestamp dataConclusao) {
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

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }
}