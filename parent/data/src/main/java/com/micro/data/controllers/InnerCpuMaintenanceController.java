package com.micro.data.controllers;

import com.micro.data.models.CPUHistoryDto;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

public interface InnerCpuMaintenanceController {

  @PostMapping("/maintenance/{configId}")
  CPUHistoryDto proceedMaintenance(@PathVariable long configId);

}
