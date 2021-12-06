package com.micro.central.controllers;

import com.micro.central.feigns.MotherboardHistoryClient;
import com.micro.data.models.MotherboardHistoryDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@Slf4j
@RestController
@RequiredArgsConstructor
public class MotherboardHistoryController {

    private final MotherboardHistoryClient motherboardHistoryClient;

    @GetMapping("/motherboard-history/{id}")
    public MotherboardHistoryDto getMotherboardHistoryById(@PathVariable Long id){
        log.info("GetMotherboardHistoryById {}", id);
        var history = motherboardHistoryClient.getById(id).getContent();
        log.info("history {}", history);

        return history;
    }

    @GetMapping("/motherboard-histories")
    public Collection<MotherboardHistoryDto> getAllMotherboardHistories(){
        log.info("getAllMotherboardHistories");
        var histories = motherboardHistoryClient.getAll().getContent();
        log.info("size = {}", histories.size());

        return histories;
    }

    @PostMapping("/motherboard-history/create")
    public MotherboardHistoryDto create(MotherboardHistoryDto history){
        log.info("createMotherboardHistory");
        var createdHistory = motherboardHistoryClient.create(history).getContent();
        log.info("history {}", createdHistory);

        return createdHistory;
    }
}
