package com.example.restservice.model.mapper;

import com.example.restservice.model.dto.UserDto;
import com.example.restservice.model.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserDto toUserDto(UserEntity source);

    UserEntity toUserEntity(UserDto source);

    List<UserDto> toUserDtoList(List<UserEntity> list);

    List<UserEntity> toUserEntityList(List<UserDto> list);  //liste ile veri kaydı yapılmadığı için kullanılmadı.


}
