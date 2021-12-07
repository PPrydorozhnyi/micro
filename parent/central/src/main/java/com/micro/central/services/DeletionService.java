package com.micro.central.services;

import com.micro.central.feigns.CpuClient;
import com.micro.central.feigns.DiscClient;
import com.micro.central.feigns.GpuClient;
import com.micro.central.feigns.MotherboardClient;
import com.micro.central.repository.CentralConfigRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeletionService {

    private final CentralConfigRepository centralConfigRepository;

    private final MotherboardClient motherboardClient;

    private final CpuClient cpuClient;

    private final DiscClient discClient;

    private final GpuClient gpuClient;

    public void deleteMotherboardConfigById(long id){
        centralConfigRepository.findCentralConfigByMotherboardId(id)
                .ifPresentOrElse(
                        s -> {throw new RuntimeException(s.getMotherboardId().toString());},
                        () -> motherboardClient.deleteConfig(id));
    }

    public void deleteGpuConfigById(long id){
        centralConfigRepository.findCentralConfigByGpuId(id)
                .ifPresentOrElse(
                        s -> {throw new RuntimeException(s.getGpuId().toString());},
                        () -> gpuClient.deleteConfig(id));
    }

    public void deleteDiscConfigById(long id){
        centralConfigRepository.findCentralConfigByGpuId(id)
                .ifPresentOrElse(
                        s -> {throw new RuntimeException(s.getDiscId().toString());},
                        () -> discClient.deleteConfig(id));
    }

    public void deleteCpuConfigById(long id){
        centralConfigRepository.findCentralConfigByGpuId(id)
                .ifPresentOrElse(
                        s -> {throw new RuntimeException(s.getCpuId().toString());},
                        () -> cpuClient.deleteConfig(id));
    }
}