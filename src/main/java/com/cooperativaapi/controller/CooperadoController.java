package com.cooperativaapi.controller;

import com.cooperativaapi.dto.CooperadoRequestDTO;
import com.cooperativaapi.dto.CooperadoResponseDTO;
import com.cooperativaapi.service.CooperadoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Tag(name = "Cooperado", description = "Gerenciamento de cooperados")
@RestController
@RequestMapping("/api/cooperados")
public class CooperadoController {

    @Autowired
    private CooperadoService service;

    @Operation(summary = "Listar todos os Cooperado")
    @GetMapping
    public List<CooperadoResponseDTO> listar(@RequestParam(required = false) String nome) {
        List<CooperadoResponseDTO> resultado = service.listar();
        if (nome != null && !nome.isBlank()) {
            resultado = resultado.stream().filter(item -> item.getNome() != null &&
                item.getNome().toLowerCase().contains(nome.toLowerCase()))
                .collect(java.util.stream.Collectors.toList());
        }
        return resultado;
    }

    @Operation(summary = "Buscar Cooperado por ID")
    @GetMapping("/{id}")
    public CooperadoResponseDTO buscar(@PathVariable Long id) { return service.buscar(id); }

    @Operation(summary = "Criar Cooperado")
    @PostMapping
    public ResponseEntity<CooperadoResponseDTO> criar(@Valid @RequestBody CooperadoRequestDTO cooperado) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(cooperado));
    }

    @Operation(summary = "Atualizar Cooperado")
    @PutMapping("/{id}")
    public CooperadoResponseDTO atualizar(@PathVariable Long id, @Valid @RequestBody CooperadoRequestDTO cooperado) {
        return service.atualizar(id, cooperado);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Excluir Cooperado")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
