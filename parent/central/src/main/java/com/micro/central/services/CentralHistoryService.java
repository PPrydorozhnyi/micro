package com.micro.central.services;

import com.micro.central.dto.CentralHistoryDto;
import com.micro.central.entity.CentralHistory;
import com.micro.central.mappers.CentralHistoryMapper;
import com.micro.central.repository.CentralHistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class CentralHistoryService {
    
    private final CentralHistoryRepository centralHistoryRepository;
    
    private final CentralHistoryMapper mapper;

    public CentralHistory getHistoryById(long id){
        return centralHistoryRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("object not found by id: " + id));
    }

    public List<CentralHistory> getHistories(){
        return StreamSupport
                .stream(centralHistoryRepository.findAll().spliterator(), false)
                .toList();
    }

    public CentralHistory createHistory(CentralHistoryDto centralHistoryDto){
        return centralHistoryRepository.save(mapper.map(centralHistoryDto));
    }
}