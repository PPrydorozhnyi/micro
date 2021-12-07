package com.micro.data.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.micro.data.models.enums.Integrity;
import lombok.Data;

import java.time.Instant;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DiscHistoryDto {
    private long id;

    private Instant time;

    private Double speed;

    private Double temperature;

    private Integrity integrity;

    private double estimatedPrice;

    private double actualPrice;
}
