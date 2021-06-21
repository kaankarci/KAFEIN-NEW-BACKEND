package com.example.restservice.model.response;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
public class BaseResponse {
    private String messageCode;
    private String messageText;

}
