package com.br.SAarcodicionados.model;

import javax.persistence.*;

@Entity
@Table(name = "marca")
public class Marca {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMarca;

    @Column(name = "nome_marca", nullable = false, unique = true)
    private String nomeMarca;

    @Column(name = "pais_origem")
    private String paisOrigem;

    @Column(name = "contato_suporte")
    private String contatoSuporte;

    // Getters and Setters

    public Long getIdMarca() {
        return idMarca;
    }

    public void setIdMarca(Long idMarca) {
        this.idMarca = idMarca;
    }

    public String getNomeMarca() {
        return nomeMarca;
    }

    public void setNomeMarca(String nomeMarca) {
        this.nomeMarca = nomeMarca;
    }

    public String getPaisOrigem() {
        return paisOrigem;
    }

    public void setPaisOrigem(String paisOrigem) {
        this.paisOrigem = paisOrigem;
    }

    public String getContatoSuporte() {
        return contatoSuporte;
    }

    public void setContatoSuporte(String contatoSuporte) {
        this.contatoSuporte = contatoSuporte;
    }
}