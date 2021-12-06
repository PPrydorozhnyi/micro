package com.micro.gpu.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "gpu_config")
public class GPUConfig {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private Boolean temperature;

    private Boolean fanOperatingMode;

    private Boolean loadQuantity;
}