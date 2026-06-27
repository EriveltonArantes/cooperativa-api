package com.cooperativaapi.mapper;

import com.cooperativaapi.dto.ProdutoRequestDTO;
import com.cooperativaapi.dto.ProdutoResponseDTO;
import com.cooperativaapi.model.Produto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProdutoMapper {

    Produto toEntity(ProdutoRequestDTO dto);

    ProdutoResponseDTO toResponseDTO(Produto entity);
}
