package com.micro.currency.controllers;

import com.micro.currency.services.CurrencyService;
import com.micro.data.controllers.InnerCurrencyController;
import com.micro.data.models.RateResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CurrencyController implements InnerCurrencyController {

  private final CurrencyService currencyService;

  @Override
  public RateResponse getCurrencyRate(String countryCode) {
    return currencyService.getCurrencyRatesByIds(countryCode);
  }

}
