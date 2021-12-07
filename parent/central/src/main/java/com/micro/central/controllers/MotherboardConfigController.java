package com.micro.central.controllers;

import com.micro.central.feigns.MotherboardClient;
import com.micro.data.models.MotherboardConfigDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Slf4j
@Controller
@RequiredArgsConstructor
public class MotherboardConfigController {

    private final MotherboardClient motherboardClient;

    @GetMapping("/motherboard-config/{id}")
    public String getMotherboardConfigById(@PathVariable Long id, Model model){
        log.info("GetMotherboardConfigById {}", id);
        var config = motherboardClient.getConfigById(id).getContent();
        log.info("config {}", config);

        model.addAttribute("config", config);

        return "motherboard/motherboardView";
    }

    @GetMapping("/motherboard-configs")
    public String getAllMotherboardConfigs(Model model){
        log.info("getAllMotherboardConfigs");
        var configs = motherboardClient.getConfigs().getContent();
        log.info("size = {}", configs.size());

        model.addAttribute("configs", configs);

        return "motherboard/motherboards";
    }

    @PostMapping("/motherboard-config/create")
    public String create(@RequestBody MotherboardConfigDto config){
        log.info("createMotherboardConfig");
        var createdConfig = motherboardClient.createConfig(config).getContent();
        log.info("config {}", createdConfig);

        return "redirect:/motherboard-config/" + createdConfig.getId();
    }
}