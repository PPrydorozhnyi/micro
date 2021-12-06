package com.micro.central.controllers;

import com.micro.central.feigns.DiscHistoryClient;
import com.micro.data.models.DiscHistoryDto;
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
public class DiscHistoryController {

    private final DiscHistoryClient discHistoryClient;

    @GetMapping("/disc-history/{id}")
    public DiscHistoryDto getDiscHistoryById(@PathVariable Long id){
        log.info("GetDiscHistoryById {}", id);
        var history = discHistoryClient.getById(id).getContent();
        log.info("history {}", history);

        return history;
    }

    @GetMapping("/disc-histories")
    public Collection<DiscHistoryDto> getAllDiscHistories(){
        log.info("getAllDiscHistories");
        var histories = discHistoryClient.getAll().getContent();
        log.info("size = {}", histories.size());

        return histories;
    }

    @PostMapping("/disc-history/create")
    public DiscHistoryDto create(DiscHistoryDto history){
        log.info("createDiscHistory");
        var createdHistory = discHistoryClient.create(history).getContent();
        log.info("history {}", createdHistory);

        return createdHistory;
    }
}