package com.micro.ipservice.controllers;

import com.micro.data.controllers.InnerIpController;
import com.micro.ipservice.services.IpService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class GeoIpController implements InnerIpController {

  private final IpService service;

  @Override
  public String getCountryCodeByIp(String ip) {
    log.info("Get country by ip: {}", ip);
    return service.getCountryById(ip);
  }
}
