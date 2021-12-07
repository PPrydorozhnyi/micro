package com.micro.central.feigns;

import com.micro.data.controllers.InnerDiscMaintenanceController;
import com.micro.data.models.DiscConfigDto;
import com.micro.data.models.DiscHistoryDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "disc", url = "http://localhost:8091")
public interface DiscClient extends InnerDiscMaintenanceController {

    @GetMapping("/disc-config")
    CollectionModel<DiscConfigDto> getConfigs();

    @GetMapping("/disc-config/{id}")
    EntityModel<DiscConfigDto> getConfigById(@PathVariable long id);

    @PostMapping("/disc-config")
    EntityModel<DiscConfigDto> createConfig(@RequestBody DiscConfigDto config);

    @GetMapping("/disc-history")
    CollectionModel<DiscHistoryDto> getHistories();

    @GetMapping("/disc-history/{id}")
    EntityModel<DiscHistoryDto> getHistoryById(@PathVariable long id);

    @PostMapping("/disc-history")
    EntityModel<DiscHistoryDto> createHistory(@RequestBody DiscHistoryDto history);
}
