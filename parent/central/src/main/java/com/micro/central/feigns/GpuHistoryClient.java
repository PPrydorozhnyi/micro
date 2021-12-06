package com.micro.central.feigns;

import com.micro.data.models.GPUHistoryDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "gpu-history", url = "http://localhost:8092")
public interface GpuHistoryClient {

    @GetMapping("/gpu-history")
    CollectionModel<GPUHistoryDto> getAll();

    @GetMapping("/gpu-history/{id}")
    EntityModel<GPUHistoryDto> getById(@PathVariable long id);

    @PostMapping("/gpu-history")
    EntityModel<GPUHistoryDto> create(@RequestBody GPUHistoryDto history);
}
