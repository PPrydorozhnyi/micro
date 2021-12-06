package com.micro.central.controllers;

import com.micro.central.feigns.DiscClient;
import com.micro.data.models.DiscConfigDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@Slf4j
@RestController
@RequiredArgsConstructor
public class DiscConfigController {

    private final DiscClient discClient;

    @GetMapping("/disc-config/{id}")
    public DiscConfigDto getDiscConfigById(@PathVariable Long id){
        log.info("GetDiscConfigById {}", id);
        var config = discClient.getConfigById(id).getContent();
        log.info("config {}", config);

        return config;
    }

    @GetMapping("/disc-configs")
    public Collection<DiscConfigDto> getAllDiscConfigs(){
        log.info("getAllDiscConfigs");
        var configs = discClient.getConfigs().getContent();
        log.info("size = {}", configs.size());

        return configs;
    }

    @PostMapping("/disc-config/create")
    public DiscConfigDto create(DiscConfigDto config){
        log.info("createDiscConfig");
        var createdConfig = discClient.createConfig(config).getContent();
        log.info("config {}", createdConfig);

        return createdConfig;
    }
}