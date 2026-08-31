package com.br.SAarcodicionados.controller;

import com.br.SAarcodicionados.model.Funcionario;
import com.br.SAarcodicionados.service.FuncionarioService;
import com.br.SAarcodicionados.dto.FuncionarioDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/funcionarios")
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;

    @GetMapping
    public List<FuncionarioDto> listarFuncionarios() {
        return funcionarioService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<FuncionarioDto> obterFuncionario(@PathVariable Long id) {
        FuncionarioDto funcionarioDto = funcionarioService.obterPorId(id);
        return ResponseEntity.ok(funcionarioDto);
    }

    @PostMapping
    public ResponseEntity<FuncionarioDto> criarFuncionario(@RequestBody FuncionarioDto funcionarioDto) {
        FuncionarioDto novoFuncionario = funcionarioService.criar(funcionarioDto);
        return ResponseEntity.status(201).body(novoFuncionario);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FuncionarioDto> atualizarFuncionario(@PathVariable Long id, @RequestBody FuncionarioDto funcionarioDto) {
        FuncionarioDto funcionarioAtualizado = funcionarioService.atualizar(id, funcionarioDto);
        return ResponseEntity.ok(funcionarioAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarFuncionario(@PathVariable Long id) {
        funcionarioService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}