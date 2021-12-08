package com.micro.central.controllers;

import com.micro.central.feigns.CpuClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Slf4j
@Controller
@RequiredArgsConstructor
public class CpuHistoryController {

    private final CpuClient cpuHistoryClient;

    @GetMapping("/cpu-history/{id}")
    public String getCpuHistoryById(@PathVariable Long id, Model model){
        log.info("GetCpuHistoryById {}", id);
        var history = cpuHistoryClient.getHistoryById(id).getContent();
        log.info("history {}", history);

        model.addAttribute("history", history);

        return "cpu/cpuHistoryView";
    }

    @GetMapping("/cpu-histories")
    public String getAllCpuHistories(Model model){
        log.info("getAllCpuHistories");
        var histories = cpuHistoryClient.getHistories().getContent();
        log.info("size = {}", histories.size());

        model.addAttribute("histories", histories);

        return "cpu/cpuHistories";
    }
}