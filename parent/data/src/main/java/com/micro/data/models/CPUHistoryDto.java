package com.micro.data.models;

import com.micro.data.models.enums.LoadQuantity;
import com.micro.data.models.enums.LoadSharing;
import lombok.Data;

import java.time.Instant;

@Data
public class CPUHistoryDto {

    private long id;

    private Instant time;

    private boolean overclocking;

    private double frequency;

    private double temperature;

    private LoadSharing loadSharing;

    private LoadQuantity loadQuantity;

}
