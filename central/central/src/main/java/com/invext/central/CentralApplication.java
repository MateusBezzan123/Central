package com.invext.central;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CentralApplication {

    public static void main(String[] args) {
        SpringApplication.run(CentralApplication.class, args);
    }

    @Bean
    public RequestDistributor requestDistributor() {
        return new RequestDistributor();
    }
}
