package com.micro.disc.controllers;

import com.micro.data.controllers.InnerDiscMaintenanceController;
import com.micro.data.models.DiscHistoryDto;
import com.micro.disc.mappers.DiscHistoryMapper;
import com.micro.disc.services.DiscMaintenanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MaintenanceController implements InnerDiscMaintenanceController {

  private final DiscMaintenanceService maintenanceService;
  private final DiscHistoryMapper mapper;

  @Override
  public DiscHistoryDto proceedMaintenance(long configId) {
    return mapper.map(maintenanceService.proceedConfig(configId));
  }

}
