package com.gy.daemon.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by yang_gao on 2017/10/1.
 */

@RestController
public class HealthCheck {

    @GetMapping(value = "/")
    public String healthState(){
        return "auto-test project is running stably";
    }
}
