package com.micro.data.models;

import java.time.Instant;
import lombok.Data;

@Data
public class GeneralHistoryResponse {

  private long id;

  private Instant time;

  private double estimatedPrice;

  private double actualPrice;

  private long configId;

  private String configName;

}
