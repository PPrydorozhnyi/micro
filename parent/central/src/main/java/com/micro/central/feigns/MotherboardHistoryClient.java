package com.micro.central.feigns;

import com.micro.data.models.MotherboardHistoryDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "motherboard-history", url = "http://localhost:8093")
public interface MotherboardHistoryClient {

    @GetMapping("/motherboard-history")
    CollectionModel<MotherboardHistoryDto> getAll();

    @GetMapping("/motherboard-history/{id}")
    EntityModel<MotherboardHistoryDto> getById(@PathVariable long id);

    @PostMapping("/motherboard-history")
    EntityModel<MotherboardHistoryDto> create(@RequestBody MotherboardHistoryDto history);
}
