package com.micro.data.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public interface InnerIpController {

  @GetMapping("/country/{ip}")
  String getCountryCodeByIp(@PathVariable String ip);

}
