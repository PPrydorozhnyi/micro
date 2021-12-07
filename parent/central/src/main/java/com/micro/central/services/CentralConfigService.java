package com.micro.central.services;

import com.micro.central.dto.CentralConfigDto;
import com.micro.central.entity.CentralConfig;
import com.micro.central.mappers.CentralConfigMapper;
import com.micro.central.repository.CentralConfigRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class CentralConfigService {

    private final CentralConfigRepository centralConfigRepository;

    private final CentralConfigMapper mapper;

    public CentralConfig getConfigById(long id){
        return centralConfigRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("object not found by id: " + id));
    }

    public List<CentralConfig> getConfigs(){
        return StreamSupport
                .stream(centralConfigRepository.findAll().spliterator(), false)
                .toList();
    }

    public CentralConfig createConfig(CentralConfigDto centralConfigDto){
        return centralConfigRepository.save(mapper.map(centralConfigDto));
    }

    public void deleteConfigById(long id){
        centralConfigRepository.deleteById(id);
    }
}