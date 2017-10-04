package com.gy.daemon.portal.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by yang_gao on 2017/10/3.
 */

@RestController
public class HealthController {

    @GetMapping(value="/info")
    public String welcome(){
        return "Auto-Test-Portal is running stably!";
    }
}
