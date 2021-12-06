package com.micro.data.models;

import com.micro.data.models.enums.FanOperatingMode;
import com.micro.data.models.enums.LoadQuantity;
import lombok.Data;

import java.time.Instant;

@Data
public class GPUHistoryDto {
    private Long id;

    private Instant time;

    private Double temperature;

    private FanOperatingMode fanOperatingMode;

    private LoadQuantity loadQuantity;
}