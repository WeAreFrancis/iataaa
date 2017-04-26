package com.wearefrancis.aiplayer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class AiPlayerApplication {
    public static void main(String[] args) {
        SpringApplication.run(AiPlayerApplication.class, args);
    }
}
