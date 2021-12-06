package com.micro.data.models;

import com.micro.data.models.enums.Integrity;
import lombok.Data;

import java.time.Instant;

@Data
public class DiscHistoryDto {
    private Long id;

    private Instant time;

    private Double speed;

    private Double temperature;

    private Integrity integrity;
}