package com.example.tx_manager;

import com.codingapi.txlcn.tm.config.EnableTransactionManagerServer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.core.env.ConfigurableEnvironment;

@SpringBootApplication
@EnableTransactionManagerServer
@Slf4j
@EnableEurekaClient
public class TxManagerApplication {

    public static void main(String[] args) {
        ConfigurableEnvironment environment = SpringApplication.run(TxManagerApplication.class, args).getEnvironment();
        log.info(" \n   txManager 已启动  \n   http://localhost:{}/", environment.getProperty("server.port"));
    }

}
