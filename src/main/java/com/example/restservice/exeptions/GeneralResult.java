package com.example.restservice.exeptions;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GeneralResult {
    private String errorCode;
    private String errorMessage;
}
