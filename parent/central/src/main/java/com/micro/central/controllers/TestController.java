package com.micro.central.controllers;

import com.micro.central.feigns.CurrencyClient;
import com.micro.central.feigns.IpClient;
import com.micro.data.models.RateResponse;
import javax.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class TestController {

  public static final String FORWARD_HEADER = "X-FORWARDED-FOR";

  private final CurrencyClient currencyClient;
  private final IpClient ipClient;

  @GetMapping("/rate/{countryCode}")
  public RateResponse getRate(@PathVariable String countryCode, HttpServletRequest request) {
    String ipAddress = request.getHeader(FORWARD_HEADER);

    if (ipAddress == null) {
      ipAddress = request.getRemoteAddr();
    }

    log.info("ip {}", ipAddress);
    return currencyClient.getCurrencyRate(countryCode);
  }

  @GetMapping("/ip/{ip}")
  public String getIp(@PathVariable String ip) {
    return ipClient.getCountryCodeByIp(ip);
  }

}
