package com.micro.central.controllers;

import com.micro.central.feigns.CpuClient;
import com.micro.data.models.CPUConfigDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
public class CpuConfigController {

    private final CpuClient cpuClient;

    @GetMapping("/cpu-config/{id}")
    public String getCpuConfigById(@PathVariable Long id, Model model){
        log.info("GetCpuConfigById {}", id);
        var config = cpuClient.getConfigById(id).getContent();
        log.info("config {}", config);

        model.addAttribute("config", config);

        return "cpu/cpuView";
    }

    @GetMapping("/cpu-configs")
    public String getAllCpuConfigs(Model model){
        log.info("getAllCpuConfigs");
        var configs = cpuClient.getConfigs().getContent();
        log.info("size = {}", configs.size());

        model.addAttribute("configs", configs);

        return "cpu/cpus";
    }

    @PostMapping("/cpu-config/create")
    public String create(@RequestBody CPUConfigDto config){
        log.info("createCpuConfig");
        var createdConfig = cpuClient.createConfig(config).getContent();
        log.info("config {}", createdConfig);

        return "redirect:/cpu-config/" + createdConfig.getId();
    }
}