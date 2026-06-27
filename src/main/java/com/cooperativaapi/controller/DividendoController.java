package com.cooperativaapi.controller;

import com.cooperativaapi.dto.DividendoRequestDTO;
import com.cooperativaapi.dto.DividendoResponseDTO;
import com.cooperativaapi.service.DividendoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Tag(name = "Dividendo", description = "Gerenciamento de dividendos")
@RestController
@RequestMapping("/api/dividendos")
public class DividendoController {

    @Autowired
    private DividendoService service;

    @Operation(summary = "Listar todos os Dividendo")
    @GetMapping
    public List<DividendoResponseDTO> listar(@RequestParam(required = false) String periodo, @RequestParam(required = false) Long cooperadoId) {
        List<DividendoResponseDTO> resultado = service.listar();
        if (periodo != null && !periodo.isBlank()) {
            resultado = resultado.stream().filter(item -> item.getPeriodo() != null &&
                item.getPeriodo().toLowerCase().contains(periodo.toLowerCase()))
                .collect(java.util.stream.Collectors.toList());
        }
        if (cooperadoId != null) {
            resultado = resultado.stream().filter(item -> cooperadoId.equals(item.getCooperadoId())).collect(java.util.stream.Collectors.toList());
        }
        return resultado;
    }

    @Operation(summary = "Buscar Dividendo por ID")
    @GetMapping("/{id}")
    public DividendoResponseDTO buscar(@PathVariable Long id) { return service.buscar(id); }

    @Operation(summary = "Criar Dividendo")
    @PostMapping
    public ResponseEntity<DividendoResponseDTO> criar(@Valid @RequestBody DividendoRequestDTO dividendo) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(dividendo));
    }

    @Operation(summary = "Atualizar Dividendo")
    @PutMapping("/{id}")
    public DividendoResponseDTO atualizar(@PathVariable Long id, @Valid @RequestBody DividendoRequestDTO dividendo) {
        return service.atualizar(id, dividendo);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Excluir Dividendo")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
