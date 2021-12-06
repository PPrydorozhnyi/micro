package com.micro.motherboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class MotherboardApplication {

  public static void main(String[] args) {
    SpringApplication.run(MotherboardApplication.class, args);
  }

}
