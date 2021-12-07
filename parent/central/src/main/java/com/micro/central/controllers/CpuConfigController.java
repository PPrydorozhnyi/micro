package com.micro.central.controllers;

import com.micro.central.feigns.CpuClient;
import com.micro.data.models.CPUConfigDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
@RequiredArgsConstructor
public class CpuConfigController {

    private final CpuClient cpuClient;

    @GetMapping("/cpu-config/{id}")
    public String getCpuConfigById(@PathVariable Long id, Model model){
        log.info("GetCpuConfigById {}", id);
        var config = cpuClient.getConfigById(id).getContent();
        log.info("config {}", config);

        model.addAttribute("config", config);

        return "cpu/cpuConfigView";
    }

    @GetMapping("/cpu-configs")
    public String getAllCpuConfigs(Model model){
        log.info("getAllCpuConfigs");
        var configs = cpuClient.getConfigs().getContent();
        log.info("size = {}", configs.size());

        model.addAttribute("configs", configs);

        return "cpu/cpuConfigs";
    }

    @GetMapping("/cpu-config/create")
    public String create(Model model){
        log.info("createCpuConfig");
        model.addAttribute("config", new CPUConfigDto());

        return "cpu/cpuConfigCreate";
    }

    @PostMapping("/cpu-config/create")
    public String create(@ModelAttribute("config") CPUConfigDto config){
        var createdConfig = cpuClient.createConfig(config).getContent();
        log.info("config {}", createdConfig);

        return "redirect:/cpu-config/" + createdConfig.getId();
    }
}