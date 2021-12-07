package com.micro.data.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.micro.data.models.enums.LoadQuantity;
import com.micro.data.models.enums.LoadSharing;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CPUHistoryDto extends GeneralHistoryResponse {

  private Boolean overclocking;

  private Double frequency;

  private Double temperature;

  private LoadSharing loadSharing;

  private LoadQuantity loadQuantity;

}
