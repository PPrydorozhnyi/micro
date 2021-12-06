package com.micro.central.controllers;

import com.micro.central.feigns.GpuClient;
import com.micro.data.models.GPUHistoryDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@Slf4j
@RestController
@RequiredArgsConstructor
public class GpuHistoryController {

    private final GpuClient gpuHistoryClient;

    @GetMapping("/gpu-history/{id}")
    public GPUHistoryDto getGpuHistoryById(@PathVariable Long id){
        log.info("GetGpuHistoryById {}", id);
        var history = gpuHistoryClient.getHistoryById(id).getContent();
        log.info("history {}", history);

        return history;
    }

    @GetMapping("/gpu-histories")
    public Collection<GPUHistoryDto> getAllGpuHistories(){
        log.info("getAllGpuHistories");
        var histories = gpuHistoryClient.getHistories().getContent();
        log.info("size = {}", histories.size());

        return histories;
    }
}
