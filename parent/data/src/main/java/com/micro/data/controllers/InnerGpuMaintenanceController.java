package com.micro.data.controllers;

import com.micro.data.models.GPUHistoryDto;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

public interface InnerGpuMaintenanceController {

  @PostMapping("/maintenance/{configId}")
  GPUHistoryDto proceedMaintenance(@PathVariable long configId);

}
