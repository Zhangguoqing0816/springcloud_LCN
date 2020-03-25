package com.example.servera.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Auther:
 * @Description:
 * @Date: 2020/3/24 16:10
 */
@FeignClient("spring-service-b")
public interface ServerBFeign {

    @GetMapping("/server_b/txlcn")
    public String execute(@RequestParam String exFlag);
}
