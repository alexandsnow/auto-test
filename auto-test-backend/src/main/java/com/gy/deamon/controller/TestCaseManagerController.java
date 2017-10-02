package com.gy.deamon.controller;

import com.gy.deamon.lib.common.base.BaseResponse;
import com.gy.deamon.dto.TestCaseReqDto;
import com.gy.deamon.service.TestCaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by yang_gao on 2017/10/1.
 */

@RestController
public class TestCaseManagerController {


    @Autowired
    TestCaseService testCaseService;

    @GetMapping(value = "/testCase")
    public BaseResponse<TestCaseReqDto> getTestCase(){
        BaseResponse<TestCaseReqDto> baseResponse = new BaseResponse<>();
        baseResponse.setResponseBody((TestCaseReqDto)testCaseService.getTestCase());
        baseResponse.setResultCode("SUCCESS");
        baseResponse.setResultMessage("get TestCase success");
        return baseResponse;
    }
}
