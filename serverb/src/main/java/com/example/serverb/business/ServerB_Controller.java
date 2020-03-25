package com.example.serverb.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther:
 * @Description:
 * @Date: 2020/3/24 16:18
 */
@RestController
@RequestMapping("/server_b")
public class ServerB_Controller {

    @Autowired
    private ServerB_Service serverB_service;

    @GetMapping("/txlcn")
    public String execute(String exFlag) {
        return serverB_service.execute(exFlag);
    }
}
