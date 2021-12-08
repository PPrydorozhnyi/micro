package com.micro.central.services;

import com.micro.central.dto.CentralConfigDto;
import com.micro.central.entity.CentralConfig;
import com.micro.central.feigns.CpuClient;
import com.micro.central.feigns.DiscClient;
import com.micro.central.feigns.GpuClient;
import com.micro.central.feigns.MotherboardClient;
import com.micro.central.mappers.CentralConfigMapper;
import com.micro.central.repository.CentralConfigRepository;
import com.micro.data.models.CPUConfigDto;
import com.micro.data.models.DiscConfigDto;
import com.micro.data.models.GPUConfigDto;
import com.micro.data.models.MotherboardConfigDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class CentralConfigService {

    private final CentralConfigRepository centralConfigRepository;

    private final CentralConfigMapper mapper;

    private final CpuClient cpuClient;

    private final DiscClient discClient;

    private final GpuClient gpuClient;

    private final MotherboardClient motherboardClient;

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

    public CPUConfigDto getCpuConfigById(long id){
        return cpuClient.getConfigById(id).getContent();
    }

    public DiscConfigDto getDiscConfigById(long id){
        return discClient.getConfigById(id).getContent();
    }

    public GPUConfigDto getGpuConfigById(long id){
        return gpuClient.getConfigById(id).getContent();
    }

    public MotherboardConfigDto getMotherboardConfigById(long id){
        return motherboardClient.getConfigById(id).getContent();
    }

    public List<CPUConfigDto> getCpuConfigs(){
        return cpuClient.getConfigs()
                .getContent()
                .stream()
                .toList();
    }

    public List<DiscConfigDto> getDiscConfigs(){
        return discClient.getConfigs()
                .getContent()
                .stream()
                .toList();
    }

    public List<GPUConfigDto> getGpuConfigs(){
        return gpuClient.getConfigs()
                .getContent()
                .stream()
                .toList();
    }

    public List<MotherboardConfigDto> getMotherboardConfigs(){
        return motherboardClient.getConfigs()
                .getContent()
                .stream()
                .toList();
    }

    public void deleteConfigById(long id){
        centralConfigRepository.deleteById(id);
    }
}