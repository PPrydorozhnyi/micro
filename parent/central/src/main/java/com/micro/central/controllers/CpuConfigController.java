package com.micro.central.controllers;

import com.micro.central.feigns.CpuClient;
import com.micro.data.models.CPUConfigDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Slf4j
@RestController
@RequiredArgsConstructor
public class CpuConfigController {

    private final CpuClient cpuClient;

    @GetMapping("/cpu-config/{id}")
    public CPUConfigDto getCpuConfigById(@PathVariable Long id){
        log.info("GetCpuConfigById {}", id);
        var config = cpuClient.getConfigById(id).getContent();
        log.info("config {}", config);

        return config;
    }

    @GetMapping("/cpu-configs")
    public Collection<CPUConfigDto> getAllCpuConfigs(){
        log.info("getAllCpuConfigs");
        var configs = cpuClient.getConfigs().getContent();
        log.info("size = {}", configs.size());

        return configs;
    }

    @PostMapping("/cpu-config/create")
    public CPUConfigDto create(@RequestBody CPUConfigDto config){
        log.info("createCpuConfig");
        var createdConfig = cpuClient.createConfig(config).getContent();
        log.info("config {}", createdConfig);

        return createdConfig;
    }
}