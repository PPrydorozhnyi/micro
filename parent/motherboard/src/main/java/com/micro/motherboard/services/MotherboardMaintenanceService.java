package com.micro.motherboard.services;

import com.micro.data.models.enums.Component;
import com.micro.data.utils.MicroUtils;
import com.micro.motherboard.entity.MotherboardHistory;
import com.micro.motherboard.repository.MotherboardConfigRepository;
import com.micro.motherboard.repository.MotherboardHistoryRepository;
import java.util.List;
import java.util.stream.IntStream;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MotherboardMaintenanceService {

  private final MotherboardConfigRepository configRepository;
  private final MotherboardHistoryRepository historyRepository;

  public MotherboardHistory proceedConfig(long configId) {
    final var config = configRepository.findById(configId)
        .orElseThrow(() -> new RuntimeException("Incorrect config id " + configId));
    final var cpuHistory = new MotherboardHistory();
    var needToSetPrice = false;

    if (config.isComponents()) {
      needToSetPrice = true;
      cpuHistory.setComponents(generateComponents());
    }

    if (config.isFreePorts()) {
      needToSetPrice = true;
      cpuHistory.setFreePorts(generateAvailableComponents());
    }

    if (needToSetPrice) {
      cpuHistory.setEstimatedPrice(generatePrice());
    }

    return historyRepository.save(cpuHistory);
  }

  private List<Component> generateAvailableComponents() {
    return IntStream.range(0, 3)
        .mapToObj(i -> generateComponent())
        .filter(component -> component != Component.CPU)
        .toList();
  }

  private List<Component> generateComponents() {
    return IntStream.range(0, 3)
        .mapToObj(i -> generateComponent())
        .distinct()
        .toList();
  }

  private Component generateComponent() {
    return Component.values()[MicroUtils.generateRandomIntTo(4)];
  }

  private double generatePrice() {
    return MicroUtils.generateRandomInRange(5, 20);
  }

}

