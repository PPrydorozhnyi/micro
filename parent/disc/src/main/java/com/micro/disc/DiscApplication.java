package com.micro.disc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class DiscApplication {

  public static void main(String[] args) {
    SpringApplication.run(DiscApplication.class, args);
  }

}
