package org.devine.productservice.configurations;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
@Qualifier("restTemplate")
public class RestTemplateConfiguration {

    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
