package com.example.restservice.model.mapper;

import com.example.restservice.model.dto.HisseDto;
import com.example.restservice.model.entity.HisseEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface HisseMapper {
    HisseMapper INSTANCE = Mappers.getMapper(HisseMapper.class);

    HisseDto toHisseDto(HisseEntity source);      //entity türünde dto newler, verileri get ile çeker

    HisseEntity toHisseEntity(HisseDto source);   //Dto türünde entity newler,
}
