package com.micro.data.models;

import lombok.Data;

@Data
public class GPUConfigDto {
    private Long id;

    private String name;

    private Boolean temperature;

    private Boolean fanOperatingMode;

    private Boolean loadQuantity;
}