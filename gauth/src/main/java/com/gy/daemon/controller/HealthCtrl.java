package com.gy.daemon.controller;

import com.gy.daemon.util.ApplicationContextHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by yang_gao on 2017/10/11.
 */
@RestController
public class HealthCtrl {

    @Value("${spring.application.name}")
    private String appName;

    @Autowired
    ApplicationContextHelper contextHelper;

    @GetMapping("/")
    public String checkHealth(){
        return appName+" is running";
    }

    @GetMapping(value="getBeans")
    public String getBeans(){
        return contextHelper.getBeansName();
    }
}
