package com.br.SAarcodicionados.service;

import com.br.SAarcodicionados.model.Os;
import com.br.SAarcodicionados.repository.OsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OsService {

    @Autowired
    private OsRepository osRepository;

    public List<Os> findAll() {
        return osRepository.findAll();
    }

    public Optional<Os> findById(Long id) {
        return osRepository.findById(id);
    }

    public Os save(Os os) {
        return osRepository.save(os);
    }

    public void deleteById(Long id) {
        osRepository.deleteById(id);
    }

    public List<Os> findByClienteId(Long clienteId) {
        return osRepository.findByClienteId(clienteId);
    }

    public List<Os> findByFuncionarioId(Long funcionarioId) {
        return osRepository.findByFuncionarioId(funcionarioId);
    }
}