package com.micro.central.dto;

import lombok.Data;

import java.time.Instant;

@Data
public class CentralHistoryDto {
    private Long id;

    private Instant time;

    private Long cpuId;

    private Long discId;

    private Long gpuId;

    private Long motherboardId;
}
