package com.cooperativaapi.mapper;

import com.cooperativaapi.dto.EntregaProdutoRequestDTO;
import com.cooperativaapi.dto.EntregaProdutoResponseDTO;
import com.cooperativaapi.model.EntregaProduto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface EntregaProdutoMapper {

    @Mapping(target = "cooperado", ignore = true)
    @Mapping(target = "produto", ignore = true)
    EntregaProduto toEntity(EntregaProdutoRequestDTO dto);

    @Mapping(target = "cooperadoId", source = "cooperado.id")
    @Mapping(target = "produtoId", source = "produto.id")
    EntregaProdutoResponseDTO toResponseDTO(EntregaProduto entity);
}
