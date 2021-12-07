package com.micro.data.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.micro.data.models.enums.Integrity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DiscHistoryDto extends GeneralHistoryResponse {

  private Double speed;

  private Double temperature;

  private Integrity integrity;

}
