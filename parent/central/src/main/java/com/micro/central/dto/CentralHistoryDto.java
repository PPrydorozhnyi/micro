package com.micro.central.dto;

import java.time.Instant;
import lombok.Data;

@Data
public class CentralHistoryDto {
    private Long id;

    private Instant time;

    private Long cpuId;

    private Long discId;

    private Long gpuId;

    private Long motherboardId;

    private long configId;

    private String configName;
}
