package com.micro.cpu.services;

import com.micro.cpu.entity.CPUHistory;
import com.micro.cpu.repository.CPUConfigRepository;
import com.micro.cpu.repository.CPUHistoryRepository;
import com.micro.data.models.enums.LoadQuantity;
import com.micro.data.models.enums.LoadSharing;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CpuMaintenanceService {

  private final CPUConfigRepository cpuConfigRepository;
  private final CPUHistoryRepository cpuHistoryRepository;
  private final Random random = new Random();

  public CPUHistory proceedConfig(long configId) {
    final var config = cpuConfigRepository.findById(configId)
        .orElseThrow(() -> new RuntimeException("Incorrect config id " + configId));
    final var cpuHistory = new CPUHistory();
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
      cpuHistory.setOverclocking(random.nextBoolean());
    }

    if (needToSetPrice) {
      cpuHistory.setEstimatedPrice(generatePrice());
    }

    return cpuHistoryRepository.save(cpuHistory);
  }

  private double generateFrequency() {
    return generateRandomInRange(1.2, 5);
  }

  private LoadQuantity generateLoadQuantity() {
    return LoadQuantity.values()[random.nextInt(0, 3)];
  }

  private LoadSharing generateLoadSharing() {
    return LoadSharing.values()[random.nextInt(0, 3)];
  }

  private double generateTemperature() {
    return generateRandomInRange(30, 80);
  }

  private double generatePrice() {
    return generateRandomInRange(5, 20);
  }

  private double generateRandomInRange(double min, double excludedMax) {
    return BigDecimal.valueOf(random.nextDouble(min, excludedMax))
        .setScale(2, RoundingMode.HALF_UP).doubleValue();
  }

}

