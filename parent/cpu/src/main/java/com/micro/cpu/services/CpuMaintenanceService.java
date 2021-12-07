package com.micro.cpu.services;

import com.micro.cpu.entity.CPUHistory;
import com.micro.cpu.repository.CPUConfigRepository;
import com.micro.cpu.repository.CPUHistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CpuMaintenanceService {

  private final CPUConfigRepository cpuConfigRepository;
  private final CPUHistoryRepository cpuHistoryRepository;

  public CPUHistory proceedConfig(long configId) {
    final var config = cpuConfigRepository.findById(configId)
        .orElseThrow(() -> new RuntimeException("Incorrect config id " + configId));
    final var cpuHistory = new CPUHistory();

    if (config.isFrequency()) {

    }

    if (config.isFrequency()) {

    }



    return cpuHistory;
  }

}

