package com.example.restservice.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HisseDto {

    private Long hisseId;
    private String kod;
    private String hisseAdi;
    private Long hisseCount;
    private Boolean status;
}
