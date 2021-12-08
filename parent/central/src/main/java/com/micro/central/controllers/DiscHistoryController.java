package com.micro.central.controllers;

import com.micro.central.feigns.DiscClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Slf4j
@Controller
@RequiredArgsConstructor
public class DiscHistoryController {

    private final DiscClient discHistoryClient;

    @GetMapping("/disc-history/{id}")
    public String getDiscHistoryById(@PathVariable Long id, Model model){
        log.info("GetDiscHistoryById {}", id);
        var history = discHistoryClient.getHistoryById(id).getContent();
        log.info("history {}", history);

        model.addAttribute("history", history);

        return "disc/discHistoryView";
    }

    @GetMapping("/disc-histories")
    public String getAllDiscHistories(Model model){
        log.info("getAllDiscHistories");
        var histories = discHistoryClient.getHistories().getContent();
        log.info("size = {}", histories.size());

        model.addAttribute("histories", histories);

        return "disc/discHistories";
    }
}