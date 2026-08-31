package com.br.SAarcodicionados.repository;

import com.br.SAarcodicionados.model.Os;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OsRepository extends JpaRepository<Os, Long> {
    // Additional query methods can be defined here if needed
}