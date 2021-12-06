package com.micro.central.feigns;

import com.micro.data.models.DiscHistoryDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "disc-history", url = "http://localhost:8091")
public interface DiscHistoryClient {

    @GetMapping("/disc-history")
    CollectionModel<DiscHistoryDto> getAll();

    @GetMapping("/disc-history/{id}")
    EntityModel<DiscHistoryDto> getById(@PathVariable long id);

    @PostMapping("/disc-history")
    EntityModel<DiscHistoryDto> create(@RequestBody DiscHistoryDto history);
}
