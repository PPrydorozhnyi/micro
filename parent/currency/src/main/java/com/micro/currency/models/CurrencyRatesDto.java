package com.micro.currency.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDate;
import java.util.Map;
import lombok.Data;

@Data
public class CurrencyRatesDto {

  private LocalDate date;
  @JsonProperty("eur")
  private Map<String, Double> rates;

}
