package com.br.SAarcodicionados.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_pessoa;

    @NotNull
    @Size(max = 20)
    @Column(name = "tipo_cliente")
    private String tipoCliente;

    @Size(max = 14)
    @Column(name = "cnpj")
    private String cnpj;

    @Column(name = "data_cadastro")
    @Temporal(TemporalType.DATE)
    private Date dataCadastro;

    // Getters and Setters

    public Integer getIdPessoa() {
        return id_pessoa;
    }

    public void setIdPessoa(Integer id_pessoa) {
        this.id_pessoa = id_pessoa;
    }

    public String getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(String tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }
}