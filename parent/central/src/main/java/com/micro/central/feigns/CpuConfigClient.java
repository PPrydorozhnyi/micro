package com.micro.central.feigns;

import com.micro.data.models.CPUConfigDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "cpu-config", url = "http://localhost:8090")
public interface CpuConfigClient {

  @GetMapping("/cpu-config")
  CollectionModel<CPUConfigDto> getAll();

  @GetMapping("/cpu-config/{id}")
  EntityModel<CPUConfigDto> getById(@PathVariable long id);

  @PostMapping("/cpu-config")
  EntityModel<CPUConfigDto> create(@RequestBody CPUConfigDto config);
}