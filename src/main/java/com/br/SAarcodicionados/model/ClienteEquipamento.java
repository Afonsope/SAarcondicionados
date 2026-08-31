package com.br.SAarcodicionados.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "cliente_equipamento")
public class ClienteEquipamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idClienteEquipamento;

    @ManyToOne
    @JoinColumn(name = "id_cliente", nullable = false)
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "id_equipamento", nullable = false)
    private Equipamento equipamento;

    @ManyToOne
    @JoinColumn(name = "id_endereco", nullable = false)
    private Endereco endereco;

    @Temporal(TemporalType.DATE)
    @Column(name = "data_instalacao", nullable = false)
    private Date dataInstalacao;

    @Temporal(TemporalType.DATE)
    @Column(name = "garantia_ate")
    private Date garantiaAte;

    @Column(name = "local_instalacao", length = 80)
    private String localInstalacao;

    // Getters and Setters

    public Long getIdClienteEquipamento() {
        return idClienteEquipamento;
    }

    public void setIdClienteEquipamento(Long idClienteEquipamento) {
        this.idClienteEquipamento = idClienteEquipamento;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Equipamento getEquipamento() {
        return equipamento;
    }

    public void setEquipamento(Equipamento equipamento) {
        this.equipamento = equipamento;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Date getDataInstalacao() {
        return dataInstalacao;
    }

    public void setDataInstalacao(Date dataInstalacao) {
        this.dataInstalacao = dataInstalacao;
    }

    public Date getGarantiaAte() {
        return garantiaAte;
    }

    public void setGarantiaAte(Date garantiaAte) {
        this.garantiaAte = garantiaAte;
    }

    public String getLocalInstalacao() {
        return localInstalacao;
    }

    public void setLocalInstalacao(String localInstalacao) {
        this.localInstalacao = localInstalacao;
    }
}