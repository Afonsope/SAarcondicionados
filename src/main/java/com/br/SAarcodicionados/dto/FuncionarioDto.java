package com.br.SAarcodicionados.dto;

import java.util.Date;

public class FuncionarioDto {
    private Integer idPessoa;
    private String nome;
    private String cpf;
    private String matricula;
    private String cargo;
    private String setor;
    private Date dataAdmissao;
    private Double salario;

    public FuncionarioDto() {
    }

    public FuncionarioDto(Integer idPessoa, String nome, String cpf, String matricula, String cargo, String setor, Date dataAdmissao, Double salario) {
        this.idPessoa = idPessoa;
        this.nome = nome;
        this.cpf = cpf;
        this.matricula = matricula;
        this.cargo = cargo;
        this.setor = setor;
        this.dataAdmissao = dataAdmissao;
        this.salario = salario;
    }

    public Integer getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(Integer idPessoa) {
        this.idPessoa = idPessoa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public Date getDataAdmissao() {
        return dataAdmissao;
    }

    public void setDataAdmissao(Date dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }
}