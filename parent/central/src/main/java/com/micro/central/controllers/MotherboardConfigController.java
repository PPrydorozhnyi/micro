package com.micro.central.controllers;

import com.micro.central.feigns.MotherboardClient;
import com.micro.central.services.DeletionService;
import com.micro.data.models.MotherboardConfigDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
@RequiredArgsConstructor
public class MotherboardConfigController {

    private final MotherboardClient motherboardClient;

    private final DeletionService deletionService;

    @GetMapping("/motherboard-config/{id}")
    public String getMotherboardConfigById(@PathVariable Long id, Model model, boolean error){
        log.info("GetMotherboardConfigById {}", id);
        var config = motherboardClient.getConfigById(id).getContent();
        log.info("config {}", config);

        model.addAttribute("config", config);

        if(error)
            model.addAttribute("error", "This config can't be deleted");

        return "motherboard/motherboardConfigView";
    }

    @GetMapping("/motherboard-configs")
    public String getAllMotherboardConfigs(Model model){
        log.info("getAllMotherboardConfigs");
        var configs = motherboardClient.getConfigs().getContent();
        log.info("size = {}", configs.size());

        model.addAttribute("configs", configs);

        return "motherboard/motherboardConfigs";
    }

    @GetMapping("/motherboard-config/create")
    public String create(Model model){
        log.info("createMotherboardConfig");
        model.addAttribute("config", new MotherboardConfigDto());

        return "motherboard/motherboardConfigCreate";
    }

    @PostMapping("/motherboard-config/create")
    public String create(@ModelAttribute("config") MotherboardConfigDto config){
        var createdConfig = motherboardClient.createConfig(config).getContent();
        log.info("config {}", createdConfig);

        return "redirect:/motherboard-config/" + createdConfig.getId();
    }

    @PostMapping("/motherboard-config/{id}")
    public String deleteById(@PathVariable long id){
        try {
            deletionService.deleteMotherboardConfigById(id);
        } catch (RuntimeException ex){
            return "redirect:/motherboard-config/" + ex.getMessage() + "?error=true";
        }
        return "redirect:/motherboard-configs";
    }
}