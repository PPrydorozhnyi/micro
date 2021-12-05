package com.micro.ipservice.services;

import com.maxmind.geoip2.DatabaseReader;
import com.maxmind.geoip2.exception.GeoIp2Exception;
import java.io.IOException;
import java.net.InetAddress;
import java.util.zip.GZIPInputStream;
import javax.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class IpService {

  private final ResourceLoader resourceLoader;
  @Value("${app.ip.path}")
  private String ipPath;
  private DatabaseReader db;

  @PostConstruct
  public void postConstruct() throws IOException {
    log.info("Load ip database");

    final var inputStream =
        new GZIPInputStream(resourceLoader.getResource(ipPath).getInputStream());

    this.db = new DatabaseReader.Builder(inputStream).build();
  }

  public String getCountryById(String ipString) {
    log.debug("getCountryById {}", ipString);
    try {
      final var ip = InetAddress.getByName(ipString);
      final var country = db.country(ip);
      if (country != null) {
        log.debug("Country for ip {} is {}", ipString, country.getCountry().getName());
        return country.getCountry().getIsoCode();
      }
      return null;
    } catch (IOException | GeoIp2Exception e) {
      log.warn("Cannot find country for ip {}. {}", ipString, e.getMessage());
      return null;
    }
  }
}
