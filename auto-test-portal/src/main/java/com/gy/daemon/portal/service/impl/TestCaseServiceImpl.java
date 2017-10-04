package com.gy.daemon.portal.service.impl;

import com.gy.daemon.lib.common.base.TestCaseBaseDto;
import com.gy.daemon.portal.service.feignService.TcFeignService;
import com.gy.daemon.portal.service.TestCaseService;
import com.gy.daemon.portal.service.feignService.feignDto.TcInfoEntity;
import com.gy.daemon.portal.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by yang_gao on 2017/10/4.
 */

@Service
public class TestCaseServiceImpl implements TestCaseService {

    @Autowired
    TcFeignService tcFeignService;

    @Override
    public List<TestCaseBaseDto> getAllTestCase() throws Exception {
        List<TestCaseBaseDto> testCaseBaseDtoList = new ArrayList<>();
        List<TcInfoEntity> tcInfoEntityList = tcFeignService.getAllTc().getResponseBody();
        String dateFormat = "yyyy/MM/dd HH:mm";
        for (TcInfoEntity tcInfoEntity : tcInfoEntityList) {
            TestCaseBaseDto baseDto = new TestCaseBaseDto();
            baseDto.setId(tcInfoEntity.getId().toString());
            baseDto.setAppId(tcInfoEntity.getAppId());
            baseDto.setAppName(tcInfoEntity.getAppName());
            baseDto.setApiName(tcInfoEntity.getApiName());
            baseDto.setTcName(tcInfoEntity.getTcName());
            baseDto.setCreateBy(tcInfoEntity.getCreatedBy());
            baseDto.setTestTime(DateUtil.dateToString(new Date(),dateFormat));
            baseDto.setCreateTime(DateUtil.dateToString(tcInfoEntity.getCreateTime(),dateFormat));
            baseDto.setIsPass(tcInfoEntity.getState().toString());
            testCaseBaseDtoList.add(baseDto);
        }
        return testCaseBaseDtoList;

    }

    @Override
    public List<TestCaseBaseDto> getTestCaseByAppId(String appId) {

        return null;
    }

    @Override
    public TestCaseBaseDto getTestCaseById() {
        return null;
    }
}
