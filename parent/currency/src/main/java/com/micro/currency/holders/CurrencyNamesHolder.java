package com.micro.currency.holders;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.Locale;
import java.util.Map;
import org.springframework.stereotype.Component;

@Component
public class CurrencyNamesHolder {

  private final Map<String, String> codeNameMap;

  public CurrencyNamesHolder() {
    final var mapper = new ObjectMapper();
    try {
      final var resourceAsStream =
          getClass().getClassLoader().getResourceAsStream("data/currency-names.json");
      codeNameMap = mapper.readValue(resourceAsStream, Map.class);
    } catch (IOException e) {
      throw new RuntimeException("Couldn't create currencies", e);
    }
  }

  public String getCurrencyName(String currencyCode) {
    return codeNameMap.get(currencyCode.toLowerCase(Locale.ENGLISH));
  }

}
