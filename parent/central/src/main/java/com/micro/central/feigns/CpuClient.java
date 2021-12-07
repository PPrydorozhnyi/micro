package com.micro.central.feigns;

import com.micro.data.controllers.InnerCpuMaintenanceController;
import com.micro.data.models.CPUConfigDto;
import com.micro.data.models.CPUHistoryDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "cpu", url = "http://localhost:8090")
public interface CpuClient extends InnerCpuMaintenanceController {

  @GetMapping("/cpu-config")
  CollectionModel<CPUConfigDto> getConfigs();

  @GetMapping("/cpu-config/{id}")
  EntityModel<CPUConfigDto> getConfigById(@PathVariable long id);

  @PostMapping("/cpu-config")
  EntityModel<CPUConfigDto> createConfig(@RequestBody CPUConfigDto config);

  @DeleteMapping("/cpu-config/{id}")
  EntityModel<CPUConfigDto> deleteConfig(@PathVariable  long id);

  @GetMapping("/cpu-history")
  CollectionModel<CPUHistoryDto> getHistories();

  @GetMapping("/cpu-history/{id}")
  EntityModel<CPUHistoryDto> getHistoryById(@PathVariable long id);

  @PostMapping("/cpu-history")
  EntityModel<CPUHistoryDto> createHistory(@RequestBody CPUHistoryDto history);
}
