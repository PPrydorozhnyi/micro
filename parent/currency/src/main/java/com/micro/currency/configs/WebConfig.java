package com.micro.currency.configs;

import java.util.Collections;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

@Configuration
public class WebConfig {

  @Bean
  public RestTemplate lcClient() {
    final var factory = new SimpleClientHttpRequestFactory();
    factory.setReadTimeout(3000);
    factory.setConnectTimeout(3000);
    final var restTemplate = new RestTemplate(new BufferingClientHttpRequestFactory(factory));
    final var converter = new MappingJackson2HttpMessageConverter();
    converter.setSupportedMediaTypes(Collections.singletonList(MediaType.APPLICATION_JSON));
    restTemplate.setMessageConverters(Collections.singletonList(converter));
    return restTemplate;
  }

}
