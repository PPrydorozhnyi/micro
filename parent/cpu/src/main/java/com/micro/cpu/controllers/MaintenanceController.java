package com.micro.cpu.controllers;

import com.micro.cpu.mappers.CpuHistoryMapper;
import com.micro.cpu.services.CpuMaintenanceService;
import com.micro.data.controllers.InnerCpuMaintenanceController;
import com.micro.data.models.CPUHistoryDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MaintenanceController implements InnerCpuMaintenanceController {

  private final CpuMaintenanceService maintenanceService;
  private final CpuHistoryMapper mapper;

  @Override
  public CPUHistoryDto proceedMaintenance(long configId) {
    return mapper.map(maintenanceService.proceedConfig(configId));
  }

}
