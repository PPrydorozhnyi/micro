package com.micro.central.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.micro.data.models.CPUHistoryDto;
import com.micro.data.models.DiscHistoryDto;
import com.micro.data.models.GPUHistoryDto;
import com.micro.data.models.MotherboardHistoryDto;
import com.micro.data.models.RateResponse;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MaintenanceResultDto {

  private long id;

  private CPUHistoryDto cpuHistory;
  private GPUHistoryDto gpuHistory;
  private DiscHistoryDto discHistory;
  private MotherboardHistoryDto motherboardHistoryDto;
  private RateResponse rate;

}
