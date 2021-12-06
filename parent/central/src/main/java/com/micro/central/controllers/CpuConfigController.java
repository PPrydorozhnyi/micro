package com.micro.central.controllers;

import com.micro.central.feigns.CpuConfigClient;
import com.micro.data.models.CPUConfigDto;
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
public class CpuConfigController {

    private final CpuConfigClient cpuConfigClient;

    @GetMapping("/cpu-config/{id}")
    public CPUConfigDto getCpuConfigById(@PathVariable Long id){
        log.info("GetCpuConfigById {}", id);
        var config = cpuConfigClient.getById(id).getContent();
        log.info("config {}", config);

        return config;
    }

    @GetMapping("/cpu-configs")
    public Collection<CPUConfigDto> getAllCpuConfigs(){
        log.info("getAllCpuConfigs");
        var configs = cpuConfigClient.getAll().getContent();
        log.info("size = {}", configs.size());

        return configs;
    }

    @PostMapping("/cpu-config/create")
    public CPUConfigDto create(CPUConfigDto config){
        log.info("createCpuConfig");
        var createdConfig = cpuConfigClient.create(config).getContent();
        log.info("config {}", createdConfig);

        return createdConfig;
    }
}