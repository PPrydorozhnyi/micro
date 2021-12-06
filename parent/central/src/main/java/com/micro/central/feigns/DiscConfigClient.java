package com.micro.central.feigns;

import com.micro.data.models.DiscConfigDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "disc-config", url = "http://localhost:8091")
public interface DiscConfigClient {

    @GetMapping("/disc-config")
    CollectionModel<DiscConfigDto> getAll();

    @GetMapping("/disc-config/{id}")
    EntityModel<DiscConfigDto> getById(@PathVariable long id);

    @PostMapping("/disc-config")
    EntityModel<DiscConfigDto> create(@RequestBody DiscConfigDto config);
}
