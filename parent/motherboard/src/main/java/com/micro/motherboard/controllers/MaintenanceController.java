package com.micro.motherboard.controllers;

import com.micro.data.controllers.InnerMotherboardMaintenanceController;
import com.micro.data.models.MotherboardHistoryDto;
import com.micro.motherboard.mappers.MotherboardHistoryMapper;
import com.micro.motherboard.services.MotherboardMaintenanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MaintenanceController implements InnerMotherboardMaintenanceController {

  private final MotherboardMaintenanceService maintenanceService;
  private final MotherboardHistoryMapper mapper;

  @Override
  public MotherboardHistoryDto proceedMaintenance(long configId) {
    return mapper.map(maintenanceService.proceedConfig(configId));
  }

}
