package com.cooperativaapi.service;

import com.cooperativaapi.dto.EntregaProdutoRequestDTO;
import com.cooperativaapi.dto.EntregaProdutoResponseDTO;
import com.cooperativaapi.exception.ResourceNotFoundException;
import com.cooperativaapi.mapper.EntregaProdutoMapper;
import com.cooperativaapi.model.EntregaProduto;
import com.cooperativaapi.repository.EntregaProdutoRepository;
import com.cooperativaapi.repository.CooperadoRepository;
import com.cooperativaapi.model.Cooperado;
import com.cooperativaapi.repository.ProdutoRepository;
import com.cooperativaapi.model.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class EntregaProdutoService {

    @Autowired
    private EntregaProdutoRepository repository;

    @Autowired
    private EntregaProdutoMapper mapper;

    @Autowired
    private CooperadoRepository cooperadoRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Transactional(readOnly = true)
    public List<EntregaProdutoResponseDTO> listar() {
        return repository.findAll().stream().map(mapper::toResponseDTO).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public EntregaProdutoResponseDTO buscar(Long id) {
        EntregaProduto entity = repository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("EntregaProduto não encontrado com id: " + id));
        return mapper.toResponseDTO(entity);
    }

    public EntregaProdutoResponseDTO criar(EntregaProdutoRequestDTO dto) {
        EntregaProduto entity = mapper.toEntity(dto);
        Cooperado cooperado = cooperadoRepository.findById(dto.getCooperadoId())
            .orElseThrow(() -> new ResourceNotFoundException("Cooperado não encontrado com id: " + dto.getCooperadoId()));
        entity.setCooperado(cooperado);
        Produto produto = produtoRepository.findById(dto.getProdutoId())
            .orElseThrow(() -> new ResourceNotFoundException("Produto não encontrado com id: " + dto.getProdutoId()));
        entity.setProduto(produto);
        EntregaProduto salvo = repository.save(entity);
        return mapper.toResponseDTO(salvo);
    }

    public EntregaProdutoResponseDTO atualizar(Long id, EntregaProdutoRequestDTO dto) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("EntregaProduto não encontrado com id: " + id);
        }
        EntregaProduto entity = mapper.toEntity(dto);
        entity.setId(id);
        Cooperado cooperado = cooperadoRepository.findById(dto.getCooperadoId())
            .orElseThrow(() -> new ResourceNotFoundException("Cooperado não encontrado com id: " + dto.getCooperadoId()));
        entity.setCooperado(cooperado);
        Produto produto = produtoRepository.findById(dto.getProdutoId())
            .orElseThrow(() -> new ResourceNotFoundException("Produto não encontrado com id: " + dto.getProdutoId()));
        entity.setProduto(produto);
        EntregaProduto salvo = repository.save(entity);
        return mapper.toResponseDTO(salvo);
    }

    public void deletar(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("EntregaProduto não encontrado com id: " + id);
        }
        repository.deleteById(id);
    }
}
