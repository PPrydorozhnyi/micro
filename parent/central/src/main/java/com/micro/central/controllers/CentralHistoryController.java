package com.micro.central.controllers;

import com.micro.central.mappers.CentralHistoryMapper;
import com.micro.central.services.CentralHistoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Slf4j
@Controller
@RequiredArgsConstructor
public class CentralHistoryController {

    private final CentralHistoryService centralHistoryService;

    private final CentralHistoryMapper mapper;

    @GetMapping("/central-history/{id}")
    public String getCentralHistoryById(@PathVariable Long id, Model model){
        log.info("GetCentralHistoryById {}", id);
        var history = mapper.map(centralHistoryService.getHistoryById(id));
        log.info("history {}", history);

        model.addAttribute("history", history);

        return "central/centralHistoryView";
    }

    @GetMapping("/central-histories")
    public String getAllCentralHistories(Model model){
        log.info("getAllCentralHistories");
        var histories = mapper.map(centralHistoryService.getHistories());
        log.info("size = {}", histories.size());

        model.addAttribute("histories", histories);

        return "central/centralHistories";
    }
}