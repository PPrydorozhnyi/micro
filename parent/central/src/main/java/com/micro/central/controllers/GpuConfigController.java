package com.micro.central.controllers;

import com.micro.central.feigns.GpuClient;
import com.micro.central.services.DeletionService;
import com.micro.data.models.GPUConfigDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
@RequiredArgsConstructor
public class GpuConfigController {

    private final GpuClient gpuClient;

    private final DeletionService deletionService;

    @GetMapping("/gpu-config/{id}")
    public String getGpuConfigById(@PathVariable Long id, Model model, boolean error){
        log.info("GetGpuConfigById {}", id);
        var config = gpuClient.getConfigById(id).getContent();
        log.info("config {}", config);

        model.addAttribute("config", config);
        
        if(error)
            model.addAttribute("error", "This config can't be deleted");

        return "gpu/gpuConfigView";
    }

    @GetMapping("/gpu-configs")
    public String getAllGpuConfigs(Model model){
        log.info("getAllGpuConfigs");
        var configs = gpuClient.getConfigs().getContent();
        log.info("size = {}", configs.size());

        model.addAttribute("configs", configs);

        return "gpu/gpuConfigs";
    }

    @GetMapping("/gpu-config/create")
    public String create(Model model){
        log.info("createGpuConfig");
        model.addAttribute("config", new GPUConfigDto());

        return "gpu/gpuConfigCreate";
    }

    @PostMapping("/gpu-config/create")
    public String create(@ModelAttribute("config") GPUConfigDto config){
        var createdConfig = gpuClient.createConfig(config).getContent();
        log.info("config {}", createdConfig);

        return "redirect:/gpu-config/" + createdConfig.getId();
    }

    @PostMapping("/gpu-config/{id}")
    public String deleteById(@PathVariable long id){
        try {
            deletionService.deleteGpuConfigById(id);
        } catch (RuntimeException ex){
            return "redirect:/gpu-config/" + ex.getMessage() + "?error=true";
        }
        return "redirect:/gpu-configs";
    }
}