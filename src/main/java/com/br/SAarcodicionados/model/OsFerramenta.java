package com.br.SAarcodicionados.model;

import javax.persistence.*;

@Entity
@Table(name = "os_ferramenta")
public class OsFerramenta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idOsFerramenta;

    @ManyToOne
    @JoinColumn(name = "id_os", nullable = false)
    private Os os;

    @ManyToOne
    @JoinColumn(name = "id_ferramenta", nullable = false)
    private Ferramenta ferramenta;

    @Column(name = "data_uso", nullable = false)
    private java.sql.Timestamp dataUso;

    public Long getIdOsFerramenta() {
        return idOsFerramenta;
    }

    public void setIdOsFerramenta(Long idOsFerramenta) {
        this.idOsFerramenta = idOsFerramenta;
    }

    public Os getOs() {
        return os;
    }

    public void setOs(Os os) {
        this.os = os;
    }

    public Ferramenta getFerramenta() {
        return ferramenta;
    }

    public void setFerramenta(Ferramenta ferramenta) {
        this.ferramenta = ferramenta;
    }

    public java.sql.Timestamp getDataUso() {
        return dataUso;
    }

    public void setDataUso(java.sql.Timestamp dataUso) {
        this.dataUso = dataUso;
    }
}