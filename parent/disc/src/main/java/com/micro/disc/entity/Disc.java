package com.micro.disc.entity;

import com.micro.disc.entity.enums.Integrity;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Disc {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private Double speed;

    private Double temperature;

    private Integrity integrity;
}
