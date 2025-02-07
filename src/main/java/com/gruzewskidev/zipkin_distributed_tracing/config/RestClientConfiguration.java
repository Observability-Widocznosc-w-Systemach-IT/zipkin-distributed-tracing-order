package com.gruzewskidev.zipkin_distributed_tracing.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class RestClientConfiguration {

   @Bean
    public RestClient restClient(RestClient.Builder builder) {
        return builder.build();
   }
}
