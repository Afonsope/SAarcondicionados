package com.br.SAarcodicionados.repository;

import com.br.SAarcodicionados.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer> {
    // Additional query methods can be defined here if needed
}