package com.micro.central.controllers;

import com.micro.central.feigns.DiscClient;
import com.micro.data.models.DiscConfigDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
@RequiredArgsConstructor
public class DiscConfigController {

    private final DiscClient discClient;

    @GetMapping("/disc-config/{id}")
    public String getDiscConfigById(@PathVariable Long id, Model model){
        log.info("GetDiscConfigById {}", id);
        var config = discClient.getConfigById(id).getContent();
        log.info("config {}", config);

        model.addAttribute("config", config);

        return "disc/discView";
    }

    @GetMapping("/disc-configs")
    public String getAllDiscConfigs(Model model){
        log.info("getAllDiscConfigs");
        var configs = discClient.getConfigs().getContent();
        log.info("size = {}", configs.size());

        model.addAttribute("configs", configs);

        return "disc/discs";
    }

    public String create(Model model){
        log.info("createDiscConfig");
        model.addAttribute("config", new DiscConfigDto());

        return "disc/discCreate";
    }

    @PostMapping("/disc-config/create")
    public String create(@ModelAttribute("config") DiscConfigDto config){
        var createdConfig = discClient.createConfig(config).getContent();
        log.info("config {}", createdConfig);

        return "redirect:/disc-config/" + createdConfig.getId();
    }
}