package com.micro.central.feigns;

import com.micro.data.models.CPUHistoryDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "cpu-history", url = "http://localhost:8090")
public interface CpuHistoryClient {

    @GetMapping("/cpu-history")
    CollectionModel<CPUHistoryDto> getAll();

    @GetMapping("/cpu-history/{id}")
    EntityModel<CPUHistoryDto> getById(@PathVariable long id);

    @PostMapping("/cpu-history")
    EntityModel<CPUHistoryDto> create(@RequestBody CPUHistoryDto history);
}