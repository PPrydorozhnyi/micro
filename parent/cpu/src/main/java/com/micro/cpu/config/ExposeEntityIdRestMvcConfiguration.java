package com.micro.cpu.config;

import com.micro.cpu.entity.CPUConfig;
import com.micro.cpu.entity.CPUHistory;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@Configuration
public class ExposeEntityIdRestMvcConfiguration implements RepositoryRestConfigurer {

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
        config.exposeIdsFor(CPUConfig.class);
        config.exposeIdsFor(CPUHistory.class);
    }
}