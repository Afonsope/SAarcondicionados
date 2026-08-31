package com.br.SAarcodicionados.model;

import javax.persistence.*;

@Entity
@Table(name = "ferramenta")
public class Ferramenta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFerramenta;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "numero_patrimonio", unique = true)
    private String numeroPatrimonio;

    @Column(name = "status", nullable = false)
    private String status = "disponivel"; // Default status

    // Getters and Setters

    public Long getIdFerramenta() {
        return idFerramenta;
    }

    public void setIdFerramenta(Long idFerramenta) {
        this.idFerramenta = idFerramenta;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNumeroPatrimonio() {
        return numeroPatrimonio;
    }

    public void setNumeroPatrimonio(String numeroPatrimonio) {
        this.numeroPatrimonio = numeroPatrimonio;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}