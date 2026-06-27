package com.cooperativaapi.service;

import com.cooperativaapi.dto.DividendoRequestDTO;
import com.cooperativaapi.dto.DividendoResponseDTO;
import com.cooperativaapi.exception.ResourceNotFoundException;
import com.cooperativaapi.mapper.DividendoMapper;
import com.cooperativaapi.model.Dividendo;
import com.cooperativaapi.repository.DividendoRepository;
import com.cooperativaapi.repository.CooperadoRepository;
import com.cooperativaapi.model.Cooperado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class DividendoService {

    @Autowired
    private DividendoRepository repository;

    @Autowired
    private DividendoMapper mapper;

    @Autowired
    private CooperadoRepository cooperadoRepository;

    @Transactional(readOnly = true)
    public List<DividendoResponseDTO> listar() {
        return repository.findAll().stream().map(mapper::toResponseDTO).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public DividendoResponseDTO buscar(Long id) {
        Dividendo entity = repository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Dividendo não encontrado com id: " + id));
        return mapper.toResponseDTO(entity);
    }

    public DividendoResponseDTO criar(DividendoRequestDTO dto) {
        Dividendo entity = mapper.toEntity(dto);
        Cooperado cooperado = cooperadoRepository.findById(dto.getCooperadoId())
            .orElseThrow(() -> new ResourceNotFoundException("Cooperado não encontrado com id: " + dto.getCooperadoId()));
        entity.setCooperado(cooperado);
        Dividendo salvo = repository.save(entity);
        return mapper.toResponseDTO(salvo);
    }

    public DividendoResponseDTO atualizar(Long id, DividendoRequestDTO dto) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Dividendo não encontrado com id: " + id);
        }
        Dividendo entity = mapper.toEntity(dto);
        entity.setId(id);
        Cooperado cooperado = cooperadoRepository.findById(dto.getCooperadoId())
            .orElseThrow(() -> new ResourceNotFoundException("Cooperado não encontrado com id: " + dto.getCooperadoId()));
        entity.setCooperado(cooperado);
        Dividendo salvo = repository.save(entity);
        return mapper.toResponseDTO(salvo);
    }

    public void deletar(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Dividendo não encontrado com id: " + id);
        }
        repository.deleteById(id);
    }
}
