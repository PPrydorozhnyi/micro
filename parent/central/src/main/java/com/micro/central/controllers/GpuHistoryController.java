package com.micro.central.controllers;

import com.micro.central.feigns.GpuClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Slf4j
@Controller
@RequiredArgsConstructor
public class GpuHistoryController {

    private final GpuClient gpuHistoryClient;

    @GetMapping("/gpu-history/{id}")
    public String getGpuHistoryById(@PathVariable Long id, Model model){
        log.info("GetGpuHistoryById {}", id);
        var history = gpuHistoryClient.getHistoryById(id).getContent();
        log.info("history {}", history);

        model.addAttribute("history", history);

        return "gpu/gpuHistoryView";
    }

    @GetMapping("/gpu-histories")
    public String getAllGpuHistories(Model model){
        log.info("getAllGpuHistories");
        var histories = gpuHistoryClient.getHistories().getContent();
        log.info("size = {}", histories.size());

        model.addAttribute("histories", histories);

        return "gpu/gpuHistories";
    }
}