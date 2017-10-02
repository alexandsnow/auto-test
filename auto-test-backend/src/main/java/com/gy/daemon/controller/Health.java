package com.gy.daemon.controller;

import com.gy.daemon.lib.common.base.BaseResponse;
import com.gy.daemon.lib.common.statecode.HttpStateCode;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by yang_gao on 2017/10/1.
 */

@RestController
public class Health {

    @GetMapping(value = "/")
    public String health(){
        return "welcome to auto-test!";
    }

    @Value("${auth}")
    String auth;

    @GetMapping(value = "/getConfig")
    public BaseResponse<String> getConfig(){
        BaseResponse<String> response = new BaseResponse<>();
        response.setResultCode(HttpStateCode.SUCCESS.toString());
        response.setResultMessage("SUCCESS");
        response.setResponseBody("auth: "+auth);
        return response;
    }
}
