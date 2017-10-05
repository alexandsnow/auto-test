package com.gy.daemon.portal.service;

import com.gy.daemon.portal.dto.TestCaseBaseDto;
import com.gy.daemon.portal.service.feignService.feignDto.TcInfoEntity;

import java.util.List;

/**
 * Created by yang_gao on 2017/10/4.
 */
public interface TestCaseService {
    List<TestCaseBaseDto> getAllTestCase() throws Exception;

    List<TestCaseBaseDto> getTestCaseByAppId(String appId);

    TestCaseBaseDto getTestCaseById();

    TestCaseBaseDto createTc(TcInfoEntity tcInfoEntity) throws Exception;

    void deleteTestCaseById(String tcId) throws Exception;
}
