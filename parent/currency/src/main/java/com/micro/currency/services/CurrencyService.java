package com.micro.currency.services;

import com.micro.currency.holders.CountryCurrencyHolder;
import com.micro.currency.holders.CurrencyNamesHolder;
import com.micro.currency.models.CurrencyRatesDto;
import com.micro.data.models.RateResponse;
import java.util.Locale;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
@RequiredArgsConstructor
public class CurrencyService {

  @Value("${app.currency.url}")
  private String url;

  private final RestTemplate restTemplate;
  private final CountryCurrencyHolder countryCurrencyHolder;
  private final CurrencyNamesHolder currencyNamesHolder;
  private Map<String, Double> rates;

  @EventListener(ApplicationReadyEvent.class)
  public void initialize() {
    updateCurrencyRates();
  }

  @Scheduled(cron = "0 0 1 * * *")
  public void updateCurrencyRates() {
    rates = getCurrencyRates();
  }

  public RateResponse getCurrencyRatesByIds(String countryCode) {
    final var currencyCode = countryCurrencyHolder.getCurrency(countryCode);
    final var rate = rates.get(currencyCode.toLowerCase(Locale.ENGLISH));
    final var currencyName = currencyNamesHolder.getCurrencyName(currencyCode);

    return new RateResponse(rate, currencyCode, currencyName);
  }

  private Map<String, Double> getCurrencyRates() {
    return restTemplate.getForObject(url, CurrencyRatesDto.class).getRates();
  }

}

