package com.micro.data.controllers;

import com.micro.data.models.RateResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public interface InnerCurrencyController {

  @GetMapping("/rate/{countryCode}")
  RateResponse getCurrencyRate(@PathVariable String countryCode);

}
