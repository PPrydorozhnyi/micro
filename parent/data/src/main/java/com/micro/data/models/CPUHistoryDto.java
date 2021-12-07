package com.micro.data.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.micro.data.models.enums.LoadQuantity;
import com.micro.data.models.enums.LoadSharing;
import java.time.Instant;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CPUHistoryDto {

  private long id;

  private Instant time;

  private Boolean overclocking;

  private Double frequency;

  private Double temperature;

  private LoadSharing loadSharing;

  private LoadQuantity loadQuantity;

  private double estimatedPrice;

  private double actualPrice;

}
