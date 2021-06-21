package com.example.restservice.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {

    private Long userId;
    private String isim;
    private String soyisim;
    private String kullaniciTipi;
    private String username;
    private String password;
    private Boolean status;

}