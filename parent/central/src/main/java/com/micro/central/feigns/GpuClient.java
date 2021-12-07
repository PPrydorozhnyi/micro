package com.micro.central.feigns;

import com.micro.data.controllers.InnerGpuMaintenanceController;
import com.micro.data.models.GPUConfigDto;
import com.micro.data.models.GPUHistoryDto;
import com.micro.data.models.MotherboardConfigDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "gpu", url = "http://localhost:8092")
public interface GpuClient extends InnerGpuMaintenanceController {
    
    @GetMapping("/gpu-config")
    CollectionModel<GPUConfigDto> getConfigs();

    @GetMapping("/gpu-config/{id}")
    EntityModel<GPUConfigDto> getConfigById(@PathVariable long id);

    @PostMapping("/gpu-config")
    EntityModel<GPUConfigDto> createConfig(@RequestBody GPUConfigDto config);

    @DeleteMapping("/gpu-config/{id}")
    EntityModel<GPUHistoryDto> deleteConfig(@PathVariable  long id);

    @GetMapping("/gpu-history")
    CollectionModel<GPUHistoryDto> getHistories();

    @GetMapping("/gpu-history/{id}")
    EntityModel<GPUHistoryDto> getHistoryById(@PathVariable long id);

    @PostMapping("/gpu-history")
    EntityModel<GPUHistoryDto> createHistory(@RequestBody GPUHistoryDto history);
}
