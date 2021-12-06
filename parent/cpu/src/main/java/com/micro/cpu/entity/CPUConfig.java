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

    private Boolean overclockingConfig;

    private Boolean frequencyConfig;

    private Boolean temperatureConfig;

    private Boolean loadSharingConfig;

    private Boolean loadQuantityConfig;
}