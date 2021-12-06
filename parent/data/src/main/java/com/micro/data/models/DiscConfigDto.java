package com.micro.data.models;

import lombok.Data;

@Data
public class DiscConfigDto {
    private Long id;

    private String name;

    private Boolean speed;

    private Boolean temperature;

    private Boolean integrity;
}