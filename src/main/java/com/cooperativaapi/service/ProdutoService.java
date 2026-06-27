package com.cooperativaapi.service;

import com.cooperativaapi.dto.ProdutoRequestDTO;
import com.cooperativaapi.dto.ProdutoResponseDTO;
import com.cooperativaapi.exception.ResourceNotFoundException;
import com.cooperativaapi.mapper.ProdutoMapper;
import com.cooperativaapi.model.Produto;
import com.cooperativaapi.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    @Autowired
    private ProdutoMapper mapper;

    @Transactional(readOnly = true)
    public List<ProdutoResponseDTO> listar() {
        return repository.findAll().stream().map(mapper::toResponseDTO).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public ProdutoResponseDTO buscar(Long id) {
        Produto entity = repository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Produto não encontrado com id: " + id));
        return mapper.toResponseDTO(entity);
    }

    public ProdutoResponseDTO criar(ProdutoRequestDTO dto) {
        Produto entity = mapper.toEntity(dto);
        Produto salvo = repository.save(entity);
        return mapper.toResponseDTO(salvo);
    }

    public ProdutoResponseDTO atualizar(Long id, ProdutoRequestDTO dto) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Produto não encontrado com id: " + id);
        }
        Produto entity = mapper.toEntity(dto);
        entity.setId(id);
        Produto salvo = repository.save(entity);
        return mapper.toResponseDTO(salvo);
    }

    public void deletar(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Produto não encontrado com id: " + id);
        }
        repository.deleteById(id);
    }
}
