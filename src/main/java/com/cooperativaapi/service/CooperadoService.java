package com.cooperativaapi.service;

import com.cooperativaapi.dto.CooperadoRequestDTO;
import com.cooperativaapi.dto.CooperadoResponseDTO;
import com.cooperativaapi.exception.ResourceNotFoundException;
import com.cooperativaapi.mapper.CooperadoMapper;
import com.cooperativaapi.model.Cooperado;
import com.cooperativaapi.repository.CooperadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class CooperadoService {

    @Autowired
    private CooperadoRepository repository;

    @Autowired
    private CooperadoMapper mapper;

    @Transactional(readOnly = true)
    public List<CooperadoResponseDTO> listar() {
        return repository.findAll().stream().map(mapper::toResponseDTO).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public CooperadoResponseDTO buscar(Long id) {
        Cooperado entity = repository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Cooperado não encontrado com id: " + id));
        return mapper.toResponseDTO(entity);
    }

    public CooperadoResponseDTO criar(CooperadoRequestDTO dto) {
        Cooperado entity = mapper.toEntity(dto);
        Cooperado salvo = repository.save(entity);
        return mapper.toResponseDTO(salvo);
    }

    public CooperadoResponseDTO atualizar(Long id, CooperadoRequestDTO dto) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Cooperado não encontrado com id: " + id);
        }
        Cooperado entity = mapper.toEntity(dto);
        entity.setId(id);
        Cooperado salvo = repository.save(entity);
        return mapper.toResponseDTO(salvo);
    }

    public void deletar(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Cooperado não encontrado com id: " + id);
        }
        repository.deleteById(id);
    }
}
