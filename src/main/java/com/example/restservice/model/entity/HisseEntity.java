package com.example.restservice.model.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "hissetbl")
public class HisseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long hisseId;
    @Column(name = "kod")
    private String kod;
    @Column(name = "hisseAdi")
    private String hisseAdi;
    @Column(name = "hisseCount")
    private Long hisseCount;
    @Column(name = "status")
    private Boolean status;
}
