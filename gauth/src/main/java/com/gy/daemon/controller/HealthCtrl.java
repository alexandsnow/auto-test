package com.gy.daemon.controller;

import com.gy.daemon.dto.dao.GUserDao;
import com.gy.daemon.dto.db.GUserDto;
import com.gy.daemon.service.GUserDetailService;
import com.gy.daemon.util.ApplicationContextHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by yang_gao on 2017/10/11.
 */
@RestController
@RequestMapping(value = "/heartbeat")
public class HealthCtrl {

    @Value("${spring.application.name}")
    private String appName;

    @Autowired
    ApplicationContextHelper contextHelper;

    @Autowired
    GUserDao gUserDao;

    @Autowired
    GUserDetailService gUserDetailService;

    @GetMapping("/")
    public String checkHealth(){
        return appName+" is running";
    }

    @GetMapping(value="/getBeans")
    public String getBeans(){
        return contextHelper.getBeansName();
    }

    @GetMapping(value="/db")
    public String checkDbHeartBeat(){
        GUserDto  user = gUserDao.selectByUserName("mickey");
        return user.toString();
    }
}
