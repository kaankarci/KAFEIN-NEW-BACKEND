package com.example.restservice.service.impl;

import com.example.restservice.exeptions.GeneralExeption;
import com.example.restservice.exeptions.GeneralResult;
import com.example.restservice.model.dto.HisseDto;
import com.example.restservice.model.entity.HisseEntity;
import com.example.restservice.model.mapper.HisseMapper;
import com.example.restservice.model.response.BaseResponse;
import com.example.restservice.repository.HisseRepository;
import com.example.restservice.service.HisseService;
import com.example.restservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional
    @Override
    public HisseDto createHisse(HisseDto hisseDto) {
        HisseEntity hisseEntity = hisseRepository.findByKodAndStatus(hisseDto.getKod(), true);
        if (Objects.nonNull(hisseEntity)) {
            throw new GeneralExeption(GeneralResult.builder()
                    .errorCode("Hata!")
                    .errorMessage("Zaten bu koda ait hisse bulunmaktadır")
                    .build());
        }
        hisseEntity = HisseMapper.INSTANCE.toHisseEntity(hisseDto);
        hisseEntity.setStatus(true);
        hisseRepository.save(hisseEntity);
        return HisseMapper.INSTANCE.toHisseDto(hisseEntity);
    }

    @Transactional(readOnly = true)
    @Override
    public List<HisseDto> getAllHisse() {
        final List<HisseEntity> hisseEntityList = hisseRepository.findByStatus(true);
        return HisseMapper.INSTANCE.toHisseDtoList(hisseEntityList);
    }

    @Transactional(readOnly = true)
    @Override
    public HisseDto getHisseByHisseId(Long hisseId) {
        final HisseEntity hisseEntity = hisseRepository.findByHisseIdAndStatus(hisseId, true);
        return HisseMapper.INSTANCE.toHisseDto(hisseEntity);
    }

    @Transactional
    @Override
    public BaseResponse deleteHisseById(Long hisseId) {
        final HisseEntity hisseEntity = hisseRepository.findByHisseIdAndStatus(hisseId, true);
        if (Objects.nonNull(hisseEntity)) {
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

    @Transactional
    @Override
    public HisseDto updateHisseByHisseName(HisseDto hisseDto) {
        final HisseEntity hisseEntity = hisseRepository.findByKodAndStatus(hisseDto.getKod(), true);
        if (Objects.isNull(hisseEntity)) {
            throw new GeneralExeption(GeneralResult.builder()
                    .errorCode("Hata!")
                    .errorMessage(" bu koda ait hisse bulunamadı")
                    .build());
        }
        hisseEntity.setHisseCount(hisseEntity.getHisseCount() + hisseDto.getHisseCount());
        hisseRepository.save(hisseEntity);
        return HisseMapper.INSTANCE.toHisseDto(hisseEntity);
    }


}
