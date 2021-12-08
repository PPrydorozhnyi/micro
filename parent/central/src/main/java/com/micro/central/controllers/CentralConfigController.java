package com.micro.central.controllers;

import com.micro.central.dto.CentralConfigDto;
import com.micro.central.mappers.CentralConfigMapper;
import com.micro.central.services.CentralConfigService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Map;

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

        if(config.getDiscId() != null)
            model.addAttribute("discConfig", centralConfigService.getDiscConfigById(config.getDiscId()));
        if(config.getCpuId() != null)
            model.addAttribute("cpuConfig", centralConfigService.getCpuConfigById(config.getCpuId()));
        if(config.getGpuId() != null)
            model.addAttribute("gpuConfig", centralConfigService.getGpuConfigById(config.getGpuId()));
        if(config.getMotherboardId() != null)
            model.addAttribute("motherboardConfig",
                    centralConfigService.getMotherboardConfigById(config.getMotherboardId()));

        return "central/centralConfigView";
    }

    @GetMapping("/central-configs")
    public String getAllCentralConfigs(Model model){
        log.info("getAllCentralConfigs");
        var configs = mapper.map(centralConfigService.getConfigs());
        log.info("size = {}", configs.size());

        model.addAttribute("configs", configs);

        return "central/centralConfigs";
    }

    @GetMapping("/central-config/create")
    public String create(Model model){
        log.info("createCentralConfig");
        model.addAllAttributes(Map.of(
                "config", new CentralConfigDto(),
                "cpuConfigs", centralConfigService.getCpuConfigs(),
                "discConfigs", centralConfigService.getDiscConfigs(),
                "gpuConfigs", centralConfigService.getGpuConfigs(),
                "motherboardConfigs", centralConfigService.getMotherboardConfigs()));

        return "central/centralConfigCreate";
    }

    @PostMapping("/central-config/create")
    public String create(@ModelAttribute("config") CentralConfigDto config){
        var createdConfig = mapper.map(centralConfigService.createConfig(config));
        log.info("config {}", createdConfig);

        return "redirect:/central-config/" + createdConfig.getId();
    }

    @PostMapping("/central-config/{id}")
    public String deleteConfig(@PathVariable long id){
        log.info("delete centralConfig with id {}", id);
        centralConfigService.deleteConfigById(id);

        return "redirect:/central-configs";
    }
}