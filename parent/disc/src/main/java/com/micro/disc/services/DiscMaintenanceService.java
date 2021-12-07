package com.micro.disc.services;

import com.micro.data.models.enums.Integrity;
import com.micro.data.utils.MicroUtils;
import com.micro.disc.entity.DiscHistory;
import com.micro.disc.repository.DiscConfigRepository;
import com.micro.disc.repository.DiscHistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DiscMaintenanceService {

  private final DiscConfigRepository configRepository;
  private final DiscHistoryRepository historyRepository;

  public DiscHistory proceedConfig(long configId) {
    final var config = configRepository.findById(configId)
        .orElseThrow(() -> new RuntimeException("Incorrect config id " + configId));
    final var history = new DiscHistory();
    history.setConfigId(configId);
    history.setConfigName(config.getName());
    var needToSetPrice = false;

    if (config.isTemperature()) {
      needToSetPrice = true;
      history.setTemperature(generateFrequency());
    }

    if (config.isIntegrity()) {
      needToSetPrice = true;
      history.setIntegrity(generateIntegrity());
    }

    if (config.isSpeed()) {
      needToSetPrice = true;
      history.setSpeed(generateSpeed());
    }

    if (needToSetPrice) {
      history.setEstimatedPrice(generatePrice());
    }

    return historyRepository.save(history);
  }

  private double generateFrequency() {
    return MicroUtils.generateRandomInRange(30, 80);
  }

  private Integrity generateIntegrity() {
    return Integrity.values()[MicroUtils.generateRandomIntTo(2)];
  }

  private double generateSpeed() {
    return MicroUtils.generateRandomInRange(50, 200);
  }

  private double generatePrice() {
    return MicroUtils.generateRandomInRange(5, 20);
  }

}

