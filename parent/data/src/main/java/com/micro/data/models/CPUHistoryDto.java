package com.micro.data.models;

import com.micro.data.models.enums.LoadQuantity;
import com.micro.data.models.enums.LoadSharing;
import lombok.Data;

import java.time.Instant;

@Data
public class CPUHistoryDto {
    private Long id;

    private Instant time;

    private Boolean overclocking;

    private Double frequency;

    private Double temperature;

    private LoadSharing loadSharing;

    private LoadQuantity loadQuantity;
}
