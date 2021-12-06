package com.micro.cpu.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "cpu_config")
public class CPUConfig {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private Boolean overclocking;

    private Boolean frequency;

    private Boolean temperature;

    private Boolean loadSharing;

    private Boolean loadQuantity;
}