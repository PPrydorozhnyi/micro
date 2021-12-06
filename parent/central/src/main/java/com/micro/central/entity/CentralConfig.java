package com.micro.central.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "central_config")
public class CentralConfig {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private Long cpuId;

    private Long discId;

    private Long gpuId;

    private Long motherboardId;
}