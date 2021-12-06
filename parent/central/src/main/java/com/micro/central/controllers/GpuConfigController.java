package com.micro.central.controllers;

import com.micro.central.feigns.GpuConfigClient;
import com.micro.data.models.GPUConfigDto;
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
public class GpuConfigController {

    private final GpuConfigClient gpuConfigClient;

    @GetMapping("/gpu-config/{id}")
    public GPUConfigDto getGpuConfigById(@PathVariable Long id){
        log.info("GetGpuConfigById {}", id);
        var config = gpuConfigClient.getById(id).getContent();
        log.info("config {}", config);

        return config;
    }

    @GetMapping("/gpu-configs")
    public Collection<GPUConfigDto> getAllGpuConfigs(){
        log.info("getAllGpuConfigs");
        var configs = gpuConfigClient.getAll().getContent();
        log.info("size = {}", configs.size());

        return configs;
    }

    @PostMapping("/gpu-config/create")
    public GPUConfigDto create(GPUConfigDto config){
        log.info("createGpuConfig");
        var createdConfig = gpuConfigClient.create(config).getContent();
        log.info("config {}", createdConfig);

        return createdConfig;
    }
}