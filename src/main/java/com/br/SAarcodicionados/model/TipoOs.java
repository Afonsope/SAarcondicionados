package com.br.SAarcodicionados.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class TipoOs {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTipoOs;
    
    private String descricao;

    public Long getIdTipoOs() {
        return idTipoOs;
    }

    public void setIdTipoOs(Long idTipoOs) {
        this.idTipoOs = idTipoOs;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}