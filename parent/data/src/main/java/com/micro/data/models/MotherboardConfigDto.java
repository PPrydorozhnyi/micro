package com.micro.data.models;

import lombok.Data;

@Data
public class MotherboardConfigDto {
    private Long id;

    private String name;

    private Boolean components;

    private Boolean freePorts;
}