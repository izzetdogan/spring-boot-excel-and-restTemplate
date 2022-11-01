package com.template.RestTemplate.config;

import com.template.RestTemplate.exception.RestTemplateRespondErrorHandler;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {

    @Bean
    public RestTemplateRespondErrorHandler errorHandler(){
        return new RestTemplateRespondErrorHandler();
    }

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplateBuilder()
                .errorHandler(errorHandler())
                .build();
    }

}
