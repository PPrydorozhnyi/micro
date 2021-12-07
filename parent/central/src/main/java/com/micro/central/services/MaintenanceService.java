package com.micro.central.services;

import com.micro.central.dto.MaintenanceResultDto;
import com.micro.central.entity.CentralHistory;
import com.micro.central.feigns.CpuClient;
import com.micro.central.feigns.CurrencyClient;
import com.micro.central.feigns.DiscClient;
import com.micro.central.feigns.GpuClient;
import com.micro.central.feigns.IpClient;
import com.micro.central.feigns.MotherboardClient;
import com.micro.central.repository.CentralConfigRepository;
import com.micro.central.repository.CentralHistoryRepository;
import java.math.BigDecimal;
import java.math.RoundingMode;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class MaintenanceService {

  private final CpuClient cpuClient;
  private final DiscClient discClient;
  private final GpuClient gpuClient;
  private final MotherboardClient motherboardClient;
  private final IpClient ipClient;
  private final CurrencyClient currencyClient;
  private final CentralConfigRepository configRepository;
  private final CentralHistoryRepository centralHistoryRepository;

  public MaintenanceResultDto proceedMaintenance(long configId, String ip) {
    final var centralConfig = configRepository.findById(configId)
        .orElseThrow(() -> new RuntimeException("Cannot find config " + configId));

    final var resultDto = new MaintenanceResultDto();
    final var countryCode = ipClient.getCountryCodeByIp(ip);
    log.info("Country code {}", countryCode);
    final var currencyRate = currencyClient.getCurrencyRate(countryCode);
    log.info("Currency rate {}", currencyRate);
    resultDto.setRate(currencyRate);

    var centralHistory = new CentralHistory();

    if (centralConfig.getCpuId() != null) {
      final var historyDto = cpuClient.proceedMaintenance(centralConfig.getCpuId());
      historyDto.setEstimatedPrice(convertToRate(historyDto.getActualPrice(), currencyRate.rate()));
      centralHistory.setCpuId(historyDto.getId());
      resultDto.setCpuHistory(historyDto);
    }

    if (centralConfig.getDiscId() != null) {
      final var historyDto = discClient.proceedMaintenance(centralConfig.getDiscId());
      historyDto.setEstimatedPrice(convertToRate(historyDto.getActualPrice(), currencyRate.rate()));
      centralHistory.setDiscId(historyDto.getId());
      resultDto.setDiscHistory(historyDto);
    }

    if (centralConfig.getGpuId() != null) {
      final var historyDto = gpuClient.proceedMaintenance(centralConfig.getGpuId());
      historyDto.setEstimatedPrice(convertToRate(historyDto.getActualPrice(), currencyRate.rate()));
      centralHistory.setGpuId(historyDto.getId());
      resultDto.setGpuHistory(historyDto);
    }

    if (centralConfig.getMotherboardId() != null) {
      final var historyDto = motherboardClient.proceedMaintenance(centralConfig.getMotherboardId());
      historyDto.setEstimatedPrice(convertToRate(historyDto.getActualPrice(), currencyRate.rate()));
      centralHistory.setMotherboardId(historyDto.getId());
      resultDto.setMotherboardHistoryDto(historyDto);
    }

    centralHistory = centralHistoryRepository.save(centralHistory);

    resultDto.setId(centralHistory.getId());

    return resultDto;
  }

  private double convertToRate(double price, double rate) {
    return BigDecimal.valueOf(price * rate)
        .setScale(2, RoundingMode.HALF_UP)
        .doubleValue();
  }

}
