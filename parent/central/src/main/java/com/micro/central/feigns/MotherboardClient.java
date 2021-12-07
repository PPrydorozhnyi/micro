package com.micro.central.feigns;

import com.micro.data.controllers.InnerMotherboardMaintenanceController;
import com.micro.data.models.MotherboardConfigDto;
import com.micro.data.models.MotherboardHistoryDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "motherboard")
public interface MotherboardClient extends InnerMotherboardMaintenanceController {

    @GetMapping("/motherboard-config")
    CollectionModel<MotherboardConfigDto> getConfigs();

    @GetMapping("/motherboard-config/{id}")
    EntityModel<MotherboardConfigDto> getConfigById(@PathVariable long id);

    @PostMapping("/motherboard-config")
    EntityModel<MotherboardConfigDto> createConfig(@RequestBody MotherboardConfigDto config);

    @GetMapping("/motherboard-history")
    CollectionModel<MotherboardHistoryDto> getHistories();

    @GetMapping("/motherboard-history/{id}")
    EntityModel<MotherboardHistoryDto> getHistoryById(@PathVariable long id);

    @PostMapping("/motherboard-history")
    EntityModel<MotherboardHistoryDto> createHistory(@RequestBody MotherboardHistoryDto history);
}
