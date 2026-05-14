package com.jrm.chronos.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@ComponentScan(basePackages = "com.jrm.chronos")
@EnableJpaAuditing
public class ChronosApplication {
    public static void main(String[] args) {
        SpringApplication.run(ChronosApplication.class, args);
    }
}
