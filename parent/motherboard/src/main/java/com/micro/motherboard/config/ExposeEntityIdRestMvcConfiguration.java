package com.micro.motherboard.config;

import com.micro.motherboard.entity.MotherboardConfig;
import com.micro.motherboard.entity.MotherboardHistory;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@Configuration
public class ExposeEntityIdRestMvcConfiguration implements RepositoryRestConfigurer {

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
        config.exposeIdsFor(MotherboardConfig.class);
        config.exposeIdsFor(MotherboardHistory.class);
    }
}