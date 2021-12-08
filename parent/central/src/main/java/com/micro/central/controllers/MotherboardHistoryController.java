package com.micro.central.controllers;

import com.micro.central.feigns.MotherboardClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Slf4j
@Controller
@RequiredArgsConstructor
public class MotherboardHistoryController {

    private final MotherboardClient motherboardHistoryClient;

    @GetMapping("/motherboard-history/{id}")
    public String getMotherboardHistoryById(@PathVariable Long id, Model model){
        log.info("GetMotherboardHistoryById {}", id);
        var history = motherboardHistoryClient.getHistoryById(id).getContent();
        log.info("history {}", history);

        model.addAttribute("history", history);

        return "motherboard/motherboardHistoryView";
    }

    @GetMapping("/motherboard-histories")
    public String getAllMotherboardHistories(Model model){
        log.info("getAllMotherboardHistories");
        var histories = motherboardHistoryClient.getHistories().getContent();
        log.info("size = {}", histories.size());

        model.addAttribute("histories", histories);

        return "motherboard/motherboardHistories";
    }
}