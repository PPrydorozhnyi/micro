package com.micro.central.controllers;

import com.micro.central.feigns.CpuHistoryClient;
import com.micro.data.models.CPUHistoryDto;
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
public class CpuHistoryController {

    private final CpuHistoryClient cpuHistoryClient;

    @GetMapping("/cpu-history/{id}")
    public CPUHistoryDto getCpuHistoryById(@PathVariable Long id){
        log.info("GetCpuHistoryById {}", id);
        var history = cpuHistoryClient.getById(id).getContent();
        log.info("history {}", history);

        return history;
    }

    @GetMapping("/cpu-histories")
    public Collection<CPUHistoryDto> getAllCpuHistories(){
        log.info("getAllCpuHistories");
        var histories = cpuHistoryClient.getAll().getContent();
        log.info("size = {}", histories.size());

        return histories;
    }

    @PostMapping("/cpu-history/create")
    public CPUHistoryDto create(CPUHistoryDto history){
        log.info("createCpuHistory");
        var createdHistory = cpuHistoryClient.create(history).getContent();
        log.info("history {}", createdHistory);

        return createdHistory;
    }
}