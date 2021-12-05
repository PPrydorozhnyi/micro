package com.micro.disc.entity;

import com.micro.disc.entity.enums.Integrity;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Disc {
    @Id
    private Long id;

    private String name;

    private Double speed;

    private Double temperature;

    private Integrity integrity;
}
