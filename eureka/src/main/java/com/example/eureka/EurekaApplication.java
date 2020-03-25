package com.example.eureka;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.core.env.ConfigurableEnvironment;

@SpringBootApplication
@EnableEurekaServer
@Slf4j
public class EurekaApplication {

    public static void main(String[] args) {
        ConfigurableEnvironment environment = SpringApplication.run(EurekaApplication.class, args).getEnvironment();
        log.info(" \n   eurekaServer 已启动  \n   http://localhost:{}/", environment.getProperty("server.port"));
    }

}
