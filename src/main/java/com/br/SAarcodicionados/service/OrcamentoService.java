package com.br.SAarcodicionados.service;

import com.br.SAarcodicionados.model.Orcamento;
import com.br.SAarcodicionados.repository.OrcamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrcamentoService {

    private final OrcamentoRepository orcamentoRepository;

    @Autowired
    public OrcamentoService(OrcamentoRepository orcamentoRepository) {
        this.orcamentoRepository = orcamentoRepository;
    }

    public List<Orcamento> findAll() {
        return orcamentoRepository.findAll();
    }

    public Optional<Orcamento> findById(Long id) {
        return orcamentoRepository.findById(id);
    }

    public Orcamento save(Orcamento orcamento) {
        return orcamentoRepository.save(orcamento);
    }

    public void deleteById(Long id) {
        orcamentoRepository.deleteById(id);
    }
}