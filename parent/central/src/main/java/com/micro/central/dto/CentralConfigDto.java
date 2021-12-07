package com.micro.central.dto;

import lombok.Data;

@Data
public class CentralConfigDto {
    private Long id;

    private String name;

    private Long cpuId;

    private Long discId;

    private Long gpuId;

    private Long motherboardId;
}