package com.micro.central.feigns;

import com.micro.data.controllers.InnerGpuMaintenanceController;
import com.micro.data.models.GPUConfigDto;
import com.micro.data.models.GPUHistoryDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "gpu")
public interface GpuClient extends InnerGpuMaintenanceController {
    
    @GetMapping("/gpu-config")
    CollectionModel<GPUConfigDto> getConfigs();

    @GetMapping("/gpu-config/{id}")
    EntityModel<GPUConfigDto> getConfigById(@PathVariable long id);

    @PostMapping("/gpu-config")
    EntityModel<GPUConfigDto> createConfig(@RequestBody GPUConfigDto config);

    @GetMapping("/gpu-history")
    CollectionModel<GPUHistoryDto> getHistories();

    @GetMapping("/gpu-history/{id}")
    EntityModel<GPUHistoryDto> getHistoryById(@PathVariable long id);

    @PostMapping("/gpu-history")
    EntityModel<GPUHistoryDto> createHistory(@RequestBody GPUHistoryDto history);
}
