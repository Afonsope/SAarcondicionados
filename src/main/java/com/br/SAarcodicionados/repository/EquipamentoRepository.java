package com.br.SAarcodicionados.repository;

import com.br.SAarcodicionados.model.Equipamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipamentoRepository extends JpaRepository<Equipamento, Integer> {
    // Additional query methods can be defined here if needed
}