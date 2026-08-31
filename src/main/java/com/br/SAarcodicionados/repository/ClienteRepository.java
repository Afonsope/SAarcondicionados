package com.br.SAarcodicionados.repository;

import com.br.SAarcodicionados.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
    // Additional query methods can be defined here if needed
}