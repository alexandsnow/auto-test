package com.gy.daemon.portal.controller;

import com.gy.daemon.lib.common.base.BaseResponse;
import com.gy.daemon.lib.common.statecode.ServiceCode;
import com.gy.daemon.portal.annotaion.Api;
import com.gy.daemon.portal.annotaion.ApiInfo;
import com.gy.daemon.portal.util.ApiInfoContainer;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by yang_gao on 2017/10/3.
 */

@RestController
public class HealthController {

    @Autowired
    ApiInfoContainer apiInfoContainer;

    @GetMapping(value="/info")
    public String welcome(){
        return "Auto-Test-Portal is running stably!";
    }

    @GetMapping(value="/getAPIs")
    @Api(value = "getAPIs",desc = "获取所有API信息")
    public BaseResponse<?> getAPIs(){
        BaseResponse<List<ApiInfo>> response = new BaseResponse<>(ServiceCode.SUCCESS,apiInfoContainer.getAPIList());
        return response;
    }
}
