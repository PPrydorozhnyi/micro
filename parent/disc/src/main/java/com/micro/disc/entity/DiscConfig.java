package com.micro.disc.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "disc_config")
public class DiscConfig {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Boolean speed;

    private Boolean temperature;

    private Boolean integrity;
}
