package com.micro.gpu.services;

import com.micro.data.models.enums.FanOperatingMode;
import com.micro.data.models.enums.LoadQuantity;
import com.micro.data.utils.MicroUtils;
import com.micro.gpu.entity.GPUHistory;
import com.micro.gpu.repository.GPUConfigRepository;
import com.micro.gpu.repository.GPUHistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GpuMaintenanceService {

  private final GPUConfigRepository configRepository;
  private final GPUHistoryRepository historyRepository;

  public GPUHistory proceedConfig(long configId) {
    final var config = configRepository.findById(configId)
        .orElseThrow(() -> new RuntimeException("Incorrect config id " + configId));
    final var cpuHistory = new GPUHistory();
    var needToSetPrice = false;

    if (config.isFanOperatingMode()) {
      needToSetPrice = true;
      cpuHistory.setFanOperatingMode(generateFanOperatingMode());
    }

    if (config.isLoadQuantity()) {
      needToSetPrice = true;
      cpuHistory.setLoadQuantity(generateLoadQuantity());
    }

    if (config.isTemperature()) {
      needToSetPrice = true;
      cpuHistory.setTemperature(generateTemperature());
    }

    if (needToSetPrice) {
      cpuHistory.setEstimatedPrice(generatePrice());
    }

    return historyRepository.save(cpuHistory);
  }


  private LoadQuantity generateLoadQuantity() {
    return LoadQuantity.values()[MicroUtils.generateRandomIntTo(3)];
  }

  private FanOperatingMode generateFanOperatingMode() {
    return FanOperatingMode.values()[MicroUtils.generateRandomIntTo(3)];
  }

  private double generateTemperature() {
    return MicroUtils.generateRandomInRange(30, 80);
  }

  private double generatePrice() {
    return MicroUtils.generateRandomInRange(5, 20);
  }

}

