package com.gy.deamon.service.impl;

import com.gy.deamon.lib.common.base.BaseTestCase;
import com.gy.deamon.dto.TestCaseReqDto;
import com.gy.deamon.service.TestCaseService;
import org.springframework.stereotype.Service;

/**
 * Created by yang_gao on 2017/10/1.
 */
@Service
public class TestCaseServiceImpl implements TestCaseService{
    @Override
    public int createTestCase(BaseTestCase baseTestCase) {
        return 0;
    }

    @Override
    public BaseTestCase getTestCase() {
        TestCaseReqDto testCaseReqDto = new TestCaseReqDto();
        testCaseReqDto.setRequestMethod("GET");
        testCaseReqDto.setCaseName("Check Running");
        testCaseReqDto.setRequestParam("{uid:M52619541}");
        testCaseReqDto.setAppId("1000068951");
        return testCaseReqDto;
    }
}
