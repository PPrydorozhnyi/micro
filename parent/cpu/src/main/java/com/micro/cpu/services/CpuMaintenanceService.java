package com.micro.cpu.services;

import com.micro.cpu.entity.CPUHistory;
import com.micro.cpu.repository.CPUConfigRepository;
import com.micro.cpu.repository.CPUHistoryRepository;
import com.micro.data.models.enums.LoadQuantity;
import com.micro.data.models.enums.LoadSharing;
import com.micro.data.utils.MicroUtils;
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
    cpuHistory.setConfigId(configId);
    cpuHistory.setConfigName(config.getName());
    var needToSetPrice = false;

    if (config.isFrequency()) {
      needToSetPrice = true;
      cpuHistory.setFrequency(generateFrequency());
    }

    if (config.isLoadQuantity()) {
      needToSetPrice = true;
      cpuHistory.setLoadQuantity(generateLoadQuantity());
    }

    if (config.isLoadSharing()) {
      needToSetPrice = true;
      cpuHistory.setLoadSharing(generateLoadSharing());
    }

    if (config.isTemperature()) {
      needToSetPrice = true;
      cpuHistory.setTemperature(generateTemperature());
    }

    if (config.isOverclocking()) {
      needToSetPrice = true;
      cpuHistory.setOverclocking(MicroUtils.generateBoolean());
    }

    if (needToSetPrice) {
      cpuHistory.setEstimatedPrice(generatePrice());
    }

    return cpuHistoryRepository.save(cpuHistory);
  }

  private double generateFrequency() {
    return MicroUtils.generateRandomInRange(1.2, 5);
  }

  private LoadQuantity generateLoadQuantity() {
    return LoadQuantity.values()[MicroUtils.generateRandomIntTo(3)];
  }

  private LoadSharing generateLoadSharing() {
    return LoadSharing.values()[MicroUtils.generateRandomIntTo(3)];
  }

  private double generateTemperature() {
    return MicroUtils.generateRandomInRange(30, 80);
  }

  private double generatePrice() {
    return MicroUtils.generateRandomInRange(5, 20);
  }

}

