package com.gy.daemon.portal.controller;

import com.gy.daemon.lib.common.base.BaseResponse;
import com.gy.daemon.lib.common.base.TestCaseBaseDto;
import com.gy.daemon.lib.common.statecode.ServiceCode;
import com.gy.daemon.portal.service.TestCaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by yang_gao on 2017/10/4.
 */

@RestController
@CrossOrigin(value = "*")
public class TestCaseController {

    private static final Logger logger = LoggerFactory.getLogger(TestCaseController.class);

    @Autowired
    TestCaseService testCaseService;


    @GetMapping(value="/tcList")
    public BaseResponse<?> getTcList(){
        logger.info("TestCaseController getTcList begin");
        BaseResponse<List<TestCaseBaseDto>> response=null;
        try {
            List<TestCaseBaseDto> responseBody = testCaseService.getAllTestCase();
            response = new BaseResponse<>(ServiceCode.SUCCESS,responseBody);
        } catch (Exception e) {
            logger.error("TestCaseController getTcList catch exception: "+e.getMessage(),e);
            response = new BaseResponse<>(ServiceCode.SERVICE_UNAVAILABLE,null);
        }
        logger.info("TestCaseController getTcList end");
        return response;
    }
}
