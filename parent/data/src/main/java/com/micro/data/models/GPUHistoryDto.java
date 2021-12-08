package com.micro.data.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.micro.data.models.enums.FanOperatingMode;
import com.micro.data.models.enums.LoadQuantity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GPUHistoryDto extends GeneralHistoryResponse {

  private Double temperature;

  private FanOperatingMode fanOperatingMode;

  private LoadQuantity loadQuantity;

}
