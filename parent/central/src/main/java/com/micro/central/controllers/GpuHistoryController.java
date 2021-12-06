package com.micro.central.controllers;

import com.micro.central.feigns.GpuHistoryClient;
import com.micro.data.models.GPUHistoryDto;
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
public class GpuHistoryController {

    private final GpuHistoryClient gpuHistoryClient;

    @GetMapping("/gpu-history/{id}")
    public GPUHistoryDto getGpuHistoryById(@PathVariable Long id){
        log.info("GetGpuHistoryById {}", id);
        var history = gpuHistoryClient.getById(id).getContent();
        log.info("history {}", history);

        return history;
    }

    @GetMapping("/gpu-histories")
    public Collection<GPUHistoryDto> getAllGpuHistories(){
        log.info("getAllGpuHistories");
        var histories = gpuHistoryClient.getAll().getContent();
        log.info("size = {}", histories.size());

        return histories;
    }

    @PostMapping("/gpu-history/create")
    public GPUHistoryDto create(GPUHistoryDto history){
        log.info("createGpuHistory");
        var createdHistory = gpuHistoryClient.create(history).getContent();
        log.info("history {}", createdHistory);

        return createdHistory;
    }
}
