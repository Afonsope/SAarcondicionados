package com.br.SAarcodicionados.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "log_auditoria")
public class LogAuditoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLog;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

    @Column(name = "acao", nullable = false)
    private String acao;

    @Column(name = "tabela_afetada", nullable = false)
    private String tabelaAfetada;

    @Column(name = "id_registro_afetado")
    private Long idRegistroAfetado;

    @Column(name = "data_hora", nullable = false)
    private LocalDateTime dataHora;

    // Getters and Setters

    public Long getIdLog() {
        return idLog;
    }

    public void setIdLog(Long idLog) {
        this.idLog = idLog;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getAcao() {
        return acao;
    }

    public void setAcao(String acao) {
        this.acao = acao;
    }

    public String getTabelaAfetada() {
        return tabelaAfetada;
    }

    public void setTabelaAfetada(String tabelaAfetada) {
        this.tabelaAfetada = tabelaAfetada;
    }

    public Long getIdRegistroAfetado() {
        return idRegistroAfetado;
    }

    public void setIdRegistroAfetado(Long idRegistroAfetado) {
        this.idRegistroAfetado = idRegistroAfetado;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }
}