package com.micro.currency.holders;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.Locale;
import java.util.Map;
import org.springframework.stereotype.Component;

@Component
public class CountryCurrencyHolder {

  private final Map<String, String> countryCurrencyMap;

  public CountryCurrencyHolder() {
    final var mapper = new ObjectMapper();
    try {
      final var resourceAsStream =
          getClass().getClassLoader().getResourceAsStream("data/country-currency.json");
      countryCurrencyMap = mapper.readValue(resourceAsStream, Map.class);
    } catch (IOException e) {
      throw new RuntimeException("Couldn't create currencies", e);
    }
  }

  public String getCurrency(String countyCode) {
    return countryCurrencyMap.get(countyCode.toUpperCase(Locale.ENGLISH));
  }

}
