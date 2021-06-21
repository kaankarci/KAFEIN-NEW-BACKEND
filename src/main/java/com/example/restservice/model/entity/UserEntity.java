package com.example.restservice.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
@Getter
@Setter
@Entity
@Table(name = "usertbl")
public class UserEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long userId;
    @Column(name="isim")
    private String isim;
    @Column(name="soyisim")
    private String soyisim;
    @Column(name="kullaniciTipi")
    private String kullaniciTipi;
    @Column(name="username")
    private String username;
    @Column(name="password")
    private String password;
    @Column(name="status")
    private Boolean status;
}
