package com.cooperativaapi.controller;

import com.cooperativaapi.dto.EntregaProdutoRequestDTO;
import com.cooperativaapi.dto.EntregaProdutoResponseDTO;
import com.cooperativaapi.service.EntregaProdutoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Tag(name = "EntregaProduto", description = "Gerenciamento de entregaprodutos")
@RestController
@RequestMapping("/api/entregaprodutos")
public class EntregaProdutoController {

    @Autowired
    private EntregaProdutoService service;

    @Operation(summary = "Listar todos os EntregaProduto")
    @GetMapping
    public List<EntregaProdutoResponseDTO> listar(@RequestParam(required = false) String qualidade, @RequestParam(required = false) Long cooperadoId, @RequestParam(required = false) Long produtoId) {
        List<EntregaProdutoResponseDTO> resultado = service.listar();
        if (qualidade != null && !qualidade.isBlank()) {
            resultado = resultado.stream().filter(item -> item.getQualidade() != null &&
                item.getQualidade().toLowerCase().contains(qualidade.toLowerCase()))
                .collect(java.util.stream.Collectors.toList());
        }
        if (cooperadoId != null) {
            resultado = resultado.stream().filter(item -> cooperadoId.equals(item.getCooperadoId())).collect(java.util.stream.Collectors.toList());
        }
        if (produtoId != null) {
            resultado = resultado.stream().filter(item -> produtoId.equals(item.getProdutoId())).collect(java.util.stream.Collectors.toList());
        }
        return resultado;
    }

    @Operation(summary = "Buscar EntregaProduto por ID")
    @GetMapping("/{id}")
    public EntregaProdutoResponseDTO buscar(@PathVariable Long id) { return service.buscar(id); }

    @Operation(summary = "Criar EntregaProduto")
    @PostMapping
    public ResponseEntity<EntregaProdutoResponseDTO> criar(@Valid @RequestBody EntregaProdutoRequestDTO entregaProduto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(entregaProduto));
    }

    @Operation(summary = "Atualizar EntregaProduto")
    @PutMapping("/{id}")
    public EntregaProdutoResponseDTO atualizar(@PathVariable Long id, @Valid @RequestBody EntregaProdutoRequestDTO entregaProduto) {
        return service.atualizar(id, entregaProduto);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Excluir EntregaProduto")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
