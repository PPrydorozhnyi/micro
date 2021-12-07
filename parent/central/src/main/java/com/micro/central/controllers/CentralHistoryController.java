package com.micro.central.controllers;

import com.micro.central.dto.CentralHistoryDto;
import com.micro.central.mappers.CentralHistoryMapper;
import com.micro.central.service.CentralHistoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@Slf4j
@RestController
@RequiredArgsConstructor
public class CentralHistoryController {

    private final CentralHistoryService centralHistoryService;

    private final CentralHistoryMapper mapper;

    @GetMapping("/central-history/{id}")
    public CentralHistoryDto getCentralHistoryById(@PathVariable Long id){
        log.info("GetCentralHistoryById {}", id);
        var history = mapper.map(centralHistoryService.getHistoryById(id));
        log.info("history {}", history);

        return history;
    }

    @GetMapping("/central-histories")
    public Collection<CentralHistoryDto> getAllCentralHistories(){
        log.info("getAllCentralHistories");
        var histories = mapper.map(centralHistoryService.getHistories());
        log.info("size = {}", histories.size());

        return histories;
    }
}
