package com.br.SAarcodicionados.controller;

import com.br.SAarcodicionados.dto.OrcamentoDto;
import com.br.SAarcodicionados.service.OrcamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orcamentos")
public class OrcamentoController {

    @Autowired
    private OrcamentoService orcamentoService;

    @GetMapping
    public ResponseEntity<List<OrcamentoDto>> listarOrcamentos() {
        List<OrcamentoDto> orcamentos = orcamentoService.listarTodos();
        return ResponseEntity.ok(orcamentos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrcamentoDto> obterOrcamento(@PathVariable Long id) {
        OrcamentoDto orcamento = orcamentoService.obterPorId(id);
        return ResponseEntity.ok(orcamento);
    }

    @PostMapping
    public ResponseEntity<OrcamentoDto> criarOrcamento(@RequestBody OrcamentoDto orcamentoDto) {
        OrcamentoDto novoOrcamento = orcamentoService.criarOrcamento(orcamentoDto);
        return ResponseEntity.status(201).body(novoOrcamento);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrcamentoDto> atualizarOrcamento(@PathVariable Long id, @RequestBody OrcamentoDto orcamentoDto) {
        OrcamentoDto orcamentoAtualizado = orcamentoService.atualizarOrcamento(id, orcamentoDto);
        return ResponseEntity.ok(orcamentoAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarOrcamento(@PathVariable Long id) {
        orcamentoService.deletarOrcamento(id);
        return ResponseEntity.noContent().build();
    }
}