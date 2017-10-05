package com.gy.daemon.portal.service.impl;

import com.gy.daemon.lib.common.base.BaseResponse;
import com.gy.daemon.portal.dto.TestCaseBaseDto;
import com.gy.daemon.portal.service.feignService.TcFeignService;
import com.gy.daemon.portal.service.TestCaseService;
import com.gy.daemon.portal.service.feignService.feignDto.TcInfoEntity;
import com.gy.daemon.lib.util.DateUtil;
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
    private TcFeignService tcFeignService;

    @Override
    public List<TestCaseBaseDto> getAllTestCase() throws Exception {
        List<TestCaseBaseDto> testCaseBaseDtoList = new ArrayList<>();
        List<TcInfoEntity> tcInfoEntityList = tcFeignService.getAllTc().getResponseBody();
        for (TcInfoEntity tcInfoEntity : tcInfoEntityList) {
            testCaseBaseDtoList.add(transTcEntityToDto(tcInfoEntity));
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

    @Override
    public TestCaseBaseDto createTc(TcInfoEntity tcInfoEntity) throws Exception {
        BaseResponse<TcInfoEntity> serviceRsp = tcFeignService.createTc(tcInfoEntity);
        return transTcEntityToDto(serviceRsp.getResponseBody());
    }

    @Override
    public void deleteTestCaseById(String tcId) throws Exception {
        tcFeignService.deleteTc(tcId);
    }


    private static TestCaseBaseDto transTcEntityToDto(TcInfoEntity tcInfoEntity){
        String dateFormat = "yyyy/MM/dd HH:mm";
        TestCaseBaseDto baseDto = new TestCaseBaseDto();
        baseDto.setId(tcInfoEntity.getId());
        baseDto.setAppId(tcInfoEntity.getAppId());
        baseDto.setAppName(tcInfoEntity.getAppName());
        baseDto.setApiName(tcInfoEntity.getApiName());
        baseDto.setTcName(tcInfoEntity.getTcName());
        baseDto.setCreateBy(tcInfoEntity.getCreatedBy());
        baseDto.setTestTime(DateUtil.dateToString(new Date(),dateFormat));
        baseDto.setCreateTime(DateUtil.dateToString(tcInfoEntity.getCreateTime(),dateFormat));
        baseDto.setIsPass(tcInfoEntity.getState()==null?"--":tcInfoEntity.getState().toString());
        baseDto.setMethod(tcInfoEntity.getMethod());
        baseDto.setUrl(tcInfoEntity.getUrl());
        baseDto.setParam(tcInfoEntity.getParam());
        return baseDto;
    }
}
