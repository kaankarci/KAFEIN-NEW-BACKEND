package com.example.restservice.service.impl;

import com.example.restservice.enums.MessageType;
import com.example.restservice.model.dto.UserDto;
import com.example.restservice.model.entity.UserEntity;
import com.example.restservice.model.mapper.UserMapper;
import com.example.restservice.model.request.LoginRequest;
import com.example.restservice.model.response.BaseResponse;
import com.example.restservice.repository.UserRepository;
import com.example.restservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    @Override
    public UserDto createUser(UserDto userDto) {
        final UserEntity userEntity = UserMapper.INSTANCE.toUserEntity(userDto);
        userEntity.setStatus(true);
        userRepository.save(userEntity);
        return UserMapper.INSTANCE.toUserDto(userEntity);
    }

    @Transactional(readOnly = true)
    @Override
    public UserDto getUserByUserId(Long userId) {
        final UserEntity userEntity = userRepository.findUserByUserId(userId,true);
        return UserMapper.INSTANCE.toUserDto(userEntity);
    }

    @Transactional(readOnly = true)
    @Override
    public List<UserDto> getAllUsers() {
        final List<UserEntity> userEntityList = userRepository.findByStatus(true);
        return UserMapper.INSTANCE.toUserDtoList(userEntityList);
    }

    @Transactional
    @Override
    public BaseResponse deleteUserById(Long userId) {
        final UserEntity userEntity = userRepository.findUserByUserId(userId,true);
        if (Objects.nonNull(userEntity)){
            userEntity.setStatus(false);
            userRepository.save(userEntity);
            return BaseResponse.builder()
                    .messageCode("Succes!")
                    .messageText("Silme işlemi başarılı!")
                    .build();
        }
        return BaseResponse.builder()
                .messageCode("Error!")
                .messageText("Silinecek eleman bulunamadı!")
                .build();
    }
    @Transactional
    @Override
    public BaseResponse loginUser(LoginRequest loginRequest) {
        final  UserEntity userEntity = userRepository.findByUsernameAndPassword(loginRequest.getUsername(),loginRequest.getPassword());
        if (Objects.nonNull(userEntity)){
            return BaseResponse.builder()
                    .messageCode(MessageType.SUCCESS.name())
                    .messageText(MessageType.SUCCESS.getMessageText())
                    .build();
        }
        return BaseResponse.builder()
                .messageCode(MessageType.ERROR.name())
                .messageText(MessageType.ERROR.getMessageText())
                .build();
    }


}
