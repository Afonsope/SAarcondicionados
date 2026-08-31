package com.br.SAarcodicionados.repository;

import com.br.SAarcodicionados.model.Orcamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrcamentoRepository extends JpaRepository<Orcamento, Integer> {
    // Additional query methods can be defined here if needed
}