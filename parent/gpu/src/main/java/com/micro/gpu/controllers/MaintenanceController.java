package com.micro.gpu.controllers;

import com.micro.data.controllers.InnerGpuMaintenanceController;
import com.micro.data.models.GPUHistoryDto;
import com.micro.gpu.mappers.GpuHistoryMapper;
import com.micro.gpu.services.GpuMaintenanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MaintenanceController implements InnerGpuMaintenanceController {

  private final GpuMaintenanceService maintenanceService;
  private final GpuHistoryMapper mapper;

  @Override
  public GPUHistoryDto proceedMaintenance(long configId) {
    return mapper.map(maintenanceService.proceedConfig(configId));
  }

}
