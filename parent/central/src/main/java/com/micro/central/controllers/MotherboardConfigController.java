package com.micro.central.controllers;

import com.micro.central.feigns.MotherboardClient;
import com.micro.data.models.MotherboardConfigDto;
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
public class MotherboardConfigController {

    private final MotherboardClient motherboardClient;

    @GetMapping("/motherboard-config/{id}")
    public MotherboardConfigDto getMotherboardConfigById(@PathVariable Long id){
        log.info("GetMotherboardConfigById {}", id);
        var config = motherboardClient.getConfigById(id).getContent();
        log.info("config {}", config);

        return config;
    }

    @GetMapping("/motherboard-configs")
    public Collection<MotherboardConfigDto> getAllMotherboardConfigs(){
        log.info("getAllMotherboardConfigs");
        var configs = motherboardClient.getConfigs().getContent();
        log.info("size = {}", configs.size());

        return configs;
    }

    @PostMapping("/motherboard-config/create")
    public MotherboardConfigDto create(MotherboardConfigDto config){
        log.info("createMotherboardConfig");
        var createdConfig = motherboardClient.createConfig(config).getContent();
        log.info("config {}", createdConfig);

        return createdConfig;
    }
}
