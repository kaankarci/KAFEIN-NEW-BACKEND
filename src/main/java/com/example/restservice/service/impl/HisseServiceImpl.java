package com.example.restservice.service.impl;

import com.example.restservice.model.dto.HisseDto;
import com.example.restservice.model.entity.HisseEntity;
import com.example.restservice.model.entity.UserEntity;
import com.example.restservice.model.mapper.HisseMapper;
import com.example.restservice.model.mapper.UserMapper;
import com.example.restservice.model.response.BaseResponse;
import com.example.restservice.repository.HisseRepository;
import com.example.restservice.service.HisseService;
import com.example.restservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class HisseServiceImpl implements HisseService {

    private final HisseRepository hisseRepository;
    private final UserService userService;

    @Autowired
    public HisseServiceImpl(HisseRepository hisseRepository, UserService userService) {
        this.hisseRepository = hisseRepository;
        this.userService = userService;
    }

    @Override
    public HisseDto createHisse(HisseDto hisseDto) {
        final HisseEntity hisseEntity = HisseMapper.INSTANCE.toHisseEntity(hisseDto);
        hisseEntity.setStatus(true);
        hisseRepository.save(hisseEntity);
        return HisseMapper.INSTANCE.toHisseDto(hisseEntity);
    }

    @Override
    public List<HisseDto> getAllHisse() {
        final List<HisseEntity> hisseEntityList = hisseRepository.findByStatus(true);
        return HisseMapper.INSTANCE.toHisseDtoList(hisseEntityList);
    }

    @Override
    public HisseDto getHisseByHisseId(Long hisseId) {
       final HisseEntity hisseEntity =hisseRepository.findByHisseIdAndStatus(hisseId,true);
        return HisseMapper.INSTANCE.toHisseDto(hisseEntity);
    }

    @Override
    public BaseResponse deleteHisseById(Long hisseId) {
        final HisseEntity hisseEntity = hisseRepository.findByHisseIdAndStatus(hisseId,true);
        if (Objects.nonNull(hisseEntity)){
            hisseEntity.setStatus(false);
            hisseRepository.save(hisseEntity);
            return BaseResponse.builder()
                    .messageCode("Success")
                    .messageText("Silme işlemi başarılı!")
                    .build();
        }
        return BaseResponse.builder()
                .messageCode("Error")
                .messageText("Silme işlemi gerçekleştirilemedi!")
                .build();
    }

}
