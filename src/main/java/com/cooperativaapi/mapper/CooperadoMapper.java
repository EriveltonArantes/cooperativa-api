package com.cooperativaapi.mapper;

import com.cooperativaapi.dto.CooperadoRequestDTO;
import com.cooperativaapi.dto.CooperadoResponseDTO;
import com.cooperativaapi.model.Cooperado;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CooperadoMapper {

    Cooperado toEntity(CooperadoRequestDTO dto);

    CooperadoResponseDTO toResponseDTO(Cooperado entity);
}
