package com.gy.daemon.config.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by yang_gao on 2017/10/1.
 */
@RestController
public class FooControl {
    @Value("${auth}")
    String auth;
    @Value("${appName}")
    String appName;

    @GetMapping(value = "/foo")
    public String getValue(){
        return "config client is running with: "+this.auth+", message :"+appName;
    }

    @GetMapping(value = "/")
    public String health(){
        return "auto-test config client is running";
    }
}
