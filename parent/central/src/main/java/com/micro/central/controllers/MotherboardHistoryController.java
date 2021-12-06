package com.micro.central.controllers;

import com.micro.central.feigns.MotherboardClient;
import com.micro.data.models.MotherboardHistoryDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@Slf4j
@RestController
@RequiredArgsConstructor
public class MotherboardHistoryController {

    private final MotherboardClient motherboardHistoryClient;

    @GetMapping("/motherboard-history/{id}")
    public MotherboardHistoryDto getMotherboardHistoryById(@PathVariable Long id){
        log.info("GetMotherboardHistoryById {}", id);
        var history = motherboardHistoryClient.getHistoryById(id).getContent();
        log.info("history {}", history);

        return history;
    }

    @GetMapping("/motherboard-histories")
    public Collection<MotherboardHistoryDto> getAllMotherboardHistories(){
        log.info("getAllMotherboardHistories");
        var histories = motherboardHistoryClient.getHistories().getContent();
        log.info("size = {}", histories.size());

        return histories;
    }
}
