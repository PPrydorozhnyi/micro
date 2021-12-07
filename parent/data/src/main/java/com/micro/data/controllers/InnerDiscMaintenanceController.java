package com.micro.data.controllers;

import com.micro.data.models.CPUHistoryDto;
import com.micro.data.models.DiscHistoryDto;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

public interface InnerDiscMaintenanceController {

  @PostMapping("/maintenance/{configId}")
  DiscHistoryDto proceedMaintenance(@PathVariable long configId);

}
