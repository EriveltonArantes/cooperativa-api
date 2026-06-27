package com.cooperativaapi.mapper;

import com.cooperativaapi.dto.DividendoRequestDTO;
import com.cooperativaapi.dto.DividendoResponseDTO;
import com.cooperativaapi.model.Dividendo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface DividendoMapper {

    @Mapping(target = "cooperado", ignore = true)
    Dividendo toEntity(DividendoRequestDTO dto);

    @Mapping(target = "cooperadoId", source = "cooperado.id")
    DividendoResponseDTO toResponseDTO(Dividendo entity);
}
