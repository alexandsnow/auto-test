package com.gy.daemon.controller;

import com.gy.daemon.dto.db.TcInfoEntity;
import com.gy.daemon.lib.common.base.BaseResponse;
import com.gy.daemon.lib.common.statecode.ServiceCode;
import com.gy.daemon.service.TestCaseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by yang_gao on 2017/10/4.
 */

@RestController
@RequestMapping(value="/tc")
public class TestCaseControl {

    private static final Logger logger = LoggerFactory.getLogger(TestCaseControl.class);

    @Autowired
    TestCaseService testCaseService;

    @GetMapping(value="/")
    public BaseResponse<?> getAllTc(){
        BaseResponse<List<TcInfoEntity>> response = null;
        List<TcInfoEntity> responseBody = null;
            try {
            responseBody = testCaseService.getAllTestCase();
            response = new BaseResponse<>(ServiceCode.SUCCESS,responseBody);
        } catch (Exception e) {
            logger.error("TestCaseControl getAllTc catch exception: "+e.getMessage(),e);
            response = new BaseResponse<>(ServiceCode.SYSTEM_ERROR,null);
        }
        return response;
    }
    @GetMapping(value="/appId")
    public BaseResponse<?> getTcByAppId(@RequestParam(value = "appId",required = true)String appId){
        BaseResponse<List<TcInfoEntity>> response = null;
        List<TcInfoEntity> responseBody = null;
        try {
            responseBody = testCaseService.getTestCaseByAppId(appId);
            response = new BaseResponse<>(ServiceCode.SUCCESS,responseBody);
        } catch (Exception e) {
            logger.error("TestCaseControl getTcByAppId catch exception: "+e.getMessage(),e);
            response = new BaseResponse<>(ServiceCode.SYSTEM_ERROR,null);
        }
        return response;
    }
    @GetMapping(value="/{tcId}")
    public BaseResponse<?> getTcByTcId(@PathVariable("tcId")Integer tcId){
        BaseResponse<TcInfoEntity> response = null;
        TcInfoEntity responseBody = null;
        try {
            responseBody = testCaseService.getTestCaseByTcId(tcId);
            response = new BaseResponse<>(ServiceCode.SUCCESS,responseBody);
        } catch (Exception e) {
            logger.error("TestCaseControl getTcByTcId catch exception: "+e.getMessage(),e);
            response = new BaseResponse<>(ServiceCode.SYSTEM_ERROR,null);
        }
        return response;
    }
    @PostMapping(value="/")
    public BaseResponse<?> createTc(@RequestBody TcInfoEntity tcInfoEntity){
        BaseResponse<String> response = null;
        try {
            testCaseService.insertTc(tcInfoEntity);
            response = new BaseResponse<>(ServiceCode.SUCCESS,null);
        } catch (Exception e) {
            logger.error("TestCaseControl createTc catch exception: "+e.getMessage(),e);
            response = new BaseResponse<>(ServiceCode.DB_OPERATION_ERROR_INSERT,null);
        }
        return response;
    }

    @PutMapping(value="/")
    public BaseResponse<?> updateTc(@RequestBody TcInfoEntity tcInfoEntity){
        BaseResponse<String> response = null;
        try {
            testCaseService.updateTc(tcInfoEntity);
            response = new BaseResponse<>(ServiceCode.SUCCESS,null);
        } catch (Exception e) {
            logger.error("TestCaseControl createTc catch exception: "+e.getMessage(),e);
            response = new BaseResponse<>(ServiceCode.DB_OPERATION_ERROR_UPDATE,null);
        }
        return response;
    }
}
