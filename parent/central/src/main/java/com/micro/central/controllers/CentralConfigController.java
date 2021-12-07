package com.micro.central.controllers;

import com.micro.central.dto.CentralConfigDto;
import com.micro.central.mappers.CentralConfigMapper;
import com.micro.central.service.CentralConfigService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
@RequiredArgsConstructor
public class CentralConfigController {
    
    private final CentralConfigService centralConfigService;
    
    private final CentralConfigMapper mapper;

    @GetMapping("/central-config/{id}")
    public String getCentralConfigById(@PathVariable Long id, Model model){
        log.info("GetCentralConfigById {}", id);
        var config = mapper.map(centralConfigService.getConfigById(id));
        log.info("config {}", config);

        model.addAttribute("config", config);

        return "central/centralView";
    }

    @GetMapping("/central-configs")
    public String getAllCentralConfigs(Model model){
        log.info("getAllCentralConfigs");
        var configs = mapper.map(centralConfigService.getConfigs());
        log.info("size = {}", configs.size());

        model.addAttribute("configs", configs);

        return "central/centrals";
    }

    public String create(Model model){
        log.info("createCentralConfig");
        model.addAttribute("config", new CentralConfigDto());

        return "central/centralCreate";
    }

    @PostMapping("/central-config/create")
    public String create(@ModelAttribute("config") CentralConfigDto config){
        var createdConfig = mapper.map(centralConfigService.createConfig(config));
        log.info("config {}", createdConfig);

        return "redirect:/central-config/" + createdConfig.getId();
    }
}