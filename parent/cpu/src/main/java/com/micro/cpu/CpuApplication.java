package com.micro.cpu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class CpuApplication {

  public static void main(String[] args) {
    SpringApplication.run(CpuApplication.class, args);
  }

}
