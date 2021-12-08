package com.micro.central.feigns;

import com.micro.data.controllers.InnerDiscMaintenanceController;
import com.micro.data.models.DiscConfigDto;
import com.micro.data.models.DiscHistoryDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "disc")
public interface DiscClient extends InnerDiscMaintenanceController {

    @GetMapping("/disc-config")
    CollectionModel<DiscConfigDto> getConfigs();

    @GetMapping("/disc-config/{id}")
    EntityModel<DiscConfigDto> getConfigById(@PathVariable long id);

    @PostMapping("/disc-config")
    EntityModel<DiscConfigDto> createConfig(@RequestBody DiscConfigDto config);

    @DeleteMapping("/disc-config/{id}")
    EntityModel<DiscConfigDto> deleteConfig(@PathVariable  long id);

    @GetMapping("/disc-history")
    CollectionModel<DiscHistoryDto> getHistories();

    @GetMapping("/disc-history/{id}")
    EntityModel<DiscHistoryDto> getHistoryById(@PathVariable long id);

    @PostMapping("/disc-history")
    EntityModel<DiscHistoryDto> createHistory(@RequestBody DiscHistoryDto history);
}
