package com.micro.data.models;

import lombok.Data;

@Data
public class CPUConfigDto {

    private Long id;

    private String name;

    private Boolean overclocking;

    private Boolean frequency;

    private Boolean temperature;

    private Boolean loadSharing;

    private Boolean loadQuantity;
}
