package com.br.SAarcodicionados.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "nota_fiscal")
public class NotaFiscal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idNotaFiscal;

    @OneToOne
    @JoinColumn(name = "id_os", unique = true, nullable = false)
    private Os os;

    @Column(name = "numero_nf", nullable = false)
    private String numeroNF;

    @Column(name = "serie", nullable = false)
    private String serie;

    @Column(name = "chave_acesso", unique = true, nullable = false)
    private String chaveAcesso;

    @Column(name = "data_emissao", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dataEmissao;

    @Column(name = "valor", nullable = false)
    private BigDecimal valor;

    @Column(name = "status", nullable = false)
    private String status;

    // Getters and Setters

    public Long getIdNotaFiscal() {
        return idNotaFiscal;
    }

    public void setIdNotaFiscal(Long idNotaFiscal) {
        this.idNotaFiscal = idNotaFiscal;
    }

    public Os getOs() {
        return os;
    }

    public void setOs(Os os) {
        this.os = os;
    }

    public String getNumeroNF() {
        return numeroNF;
    }

    public void setNumeroNF(String numeroNF) {
        this.numeroNF = numeroNF;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getChaveAcesso() {
        return chaveAcesso;
    }

    public void setChaveAcesso(String chaveAcesso) {
        this.chaveAcesso = chaveAcesso;
    }

    public Date getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(Date dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}