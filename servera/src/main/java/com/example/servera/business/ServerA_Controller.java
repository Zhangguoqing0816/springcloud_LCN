package com.example.servera.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther:
 * @Description:
 * @Date: 2020/3/24 16:18
 */
@RestController
@RequestMapping("/server_a")
public class ServerA_Controller {

    @Autowired
    private ServerA_Service serverA_service;

    @GetMapping("/txlcn")
    public String execute(@RequestParam(value = "exFlag") String exFlag) {
        System.out.println("server a  into  controller exFlag=" + exFlag);
        return serverA_service.execute(exFlag);
    }
}
