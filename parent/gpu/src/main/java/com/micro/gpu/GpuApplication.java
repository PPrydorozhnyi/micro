package com.micro.gpu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class GpuApplication {

  public static void main(String[] args) {
    SpringApplication.run(GpuApplication.class, args);
  }

}
