package com.micro.central.feigns;

import com.micro.data.models.GPUConfigDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "gpu-config", url = "http://localhost:8092")
public interface GpuConfigClient {
    
    @GetMapping("/gpu-config")
    CollectionModel<GPUConfigDto> getAll();

    @GetMapping("/gpu-config/{id}")
    EntityModel<GPUConfigDto> getById(@PathVariable long id);

    @PostMapping("/gpu-config")
    EntityModel<GPUConfigDto> create(@RequestBody GPUConfigDto config);
}
