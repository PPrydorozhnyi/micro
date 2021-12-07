package com.micro.data.controllers;

import com.micro.data.models.MotherboardHistoryDto;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

public interface InnerMotherboardMaintenanceController {

  @PostMapping("/maintenance/{configId}")
  MotherboardHistoryDto proceedMaintenance(@PathVariable long configId);

}
