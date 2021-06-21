package com.example.restservice.service;

import com.example.restservice.model.dto.HisseDto;
import com.example.restservice.model.response.BaseResponse;

import java.util.List;

public interface HisseService {

    HisseDto createHisse(HisseDto hisseDto);    // HisseServiceImpl içerisinde oluşturulacak parametre ve türü service içinde oluşturuldu

    List<HisseDto> getAllHisse();

    HisseDto getHisseByHisseId(Long hisseId);

    BaseResponse deleteHisseById(Long hisseId);

    HisseDto createHisseByHisseName(HisseDto hisseDto);
}
