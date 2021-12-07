package com.micro.central.controllers;

import com.micro.central.dto.CentralConfigDto;
import com.micro.central.mappers.CentralConfigMapper;
import com.micro.central.service.CentralConfigService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Slf4j
@RestController
@RequiredArgsConstructor
public class CentralConfigController {
    
    private final CentralConfigService centralConfigService;
    
    private final CentralConfigMapper mapper;

    @GetMapping("/central-config/{id}")
    public CentralConfigDto getCentralConfigById(@PathVariable Long id){
        log.info("GetCentralConfigById {}", id);
        var config = mapper.map(centralConfigService.getConfigById(id));
        log.info("config {}", config);

        return config;
    }

    @GetMapping("/central-configs")
    public Collection<CentralConfigDto> getAllCentralConfigs(){
        log.info("getAllCentralConfigs");
        var configs = mapper.map(centralConfigService.getConfigs());
        log.info("size = {}", configs.size());

        return configs;
    }

    @PostMapping("/central-config/create")
    public CentralConfigDto create(@RequestBody CentralConfigDto config){
        log.info("createCentralConfig");
        var createdConfig = mapper.map(centralConfigService.createConfig(config));
        log.info("config {}", createdConfig);

        return createdConfig;
    }
}
