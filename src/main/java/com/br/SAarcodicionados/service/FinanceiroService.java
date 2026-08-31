package com.br.SAarcodicionados.service;

import com.br.SAarcodicionados.model.Pagamento;
import com.br.SAarcodicionados.model.Comissao;
import com.br.SAarcodicionados.repository.PagamentoRepository;
import com.br.SAarcodicionados.repository.ComissaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FinanceiroService {

    private final PagamentoRepository pagamentoRepository;
    private final ComissaoRepository comissaoRepository;

    @Autowired
    public FinanceiroService(PagamentoRepository pagamentoRepository, ComissaoRepository comissaoRepository) {
        this.pagamentoRepository = pagamentoRepository;
        this.comissaoRepository = comissaoRepository;
    }

    public Pagamento criarPagamento(Pagamento pagamento) {
        return pagamentoRepository.save(pagamento);
    }

    public Comissao criarComissao(Comissao comissao) {
        return comissaoRepository.save(comissao);
    }

    public List<Pagamento> listarPagamentos() {
        return pagamentoRepository.findAll();
    }

    public List<Comissao> listarComissoes() {
        return comissaoRepository.findAll();
    }

    public Pagamento buscarPagamentoPorId(Long id) {
        return pagamentoRepository.findById(id).orElse(null);
    }

    public Comissao buscarComissaoPorId(Long id) {
        return comissaoRepository.findById(id).orElse(null);
    }

    public void deletarPagamento(Long id) {
        pagamentoRepository.deleteById(id);
    }

    public void deletarComissao(Long id) {
        comissaoRepository.deleteById(id);
    }
}