package com.example.serverc.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther:
 * @Description:
 * @Date: 2020/3/24 16:09
 */
@RestController
@RequestMapping("/server_c")
public class ServerC_Controller {


    @Autowired
    private ServerC_Service serverC_service;

    @GetMapping("/txlcn")
    public String execute(String exFlag) {
        return serverC_service.execute(exFlag);
    }
}
