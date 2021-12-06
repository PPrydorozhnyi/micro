package com.micro.central.feigns;

import com.micro.data.models.MotherboardConfigDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "motherboard-config", url = "http://localhost:8093")
public interface MotherboardConfigClient {

    @GetMapping("/motherboard-config")
    CollectionModel<MotherboardConfigDto> getAll();

    @GetMapping("/motherboard-config/{id}")
    EntityModel<MotherboardConfigDto> getById(@PathVariable long id);

    @PostMapping("/motherboard-config")
    EntityModel<MotherboardConfigDto> create(@RequestBody MotherboardConfigDto config);
}
