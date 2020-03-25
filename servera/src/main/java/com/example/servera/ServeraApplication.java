package com.example.servera;

import com.codingapi.txlcn.tc.config.EnableDistributedTransaction;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.core.env.ConfigurableEnvironment;

@Slf4j
@SpringBootApplication
@EnableFeignClients
@EnableEurekaClient
@EnableDistributedTransaction
public class ServeraApplication {

    public static void main(String[] args) {
        ConfigurableEnvironment environment = SpringApplication.run(ServeraApplication.class, args).getEnvironment();
        log.info(" \n   server A 已启动  \n   http://localhost:{}/", environment.getProperty("server.port"));
    }

}
