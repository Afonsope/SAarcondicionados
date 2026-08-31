package com.br.SAarcodicionados.controller;

import com.br.SAarcodicionados.dto.OsDto;
import com.br.SAarcodicionados.service.OsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/os")
public class OsController {

    @Autowired
    private OsService osService;

    @GetMapping
    public ResponseEntity<List<OsDto>> getAllOs() {
        List<OsDto> osList = osService.findAll();
        return ResponseEntity.ok(osList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OsDto> getOsById(@PathVariable Long id) {
        OsDto osDto = osService.findById(id);
        return ResponseEntity.ok(osDto);
    }

    @PostMapping
    public ResponseEntity<OsDto> createOs(@RequestBody OsDto osDto) {
        OsDto createdOs = osService.createOs(osDto);
        return ResponseEntity.status(201).body(createdOs);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OsDto> updateOs(@PathVariable Long id, @RequestBody OsDto osDto) {
        OsDto updatedOs = osService.updateOs(id, osDto);
        return ResponseEntity.ok(updatedOs);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOs(@PathVariable Long id) {
        osService.deleteOs(id);
        return ResponseEntity.noContent().build();
    }
}