package com.gy.daemon.portal.controller;

import com.gy.daemon.lib.common.base.BaseResponse;
import com.gy.daemon.portal.annotaion.Api;
import com.gy.daemon.portal.dto.TestCaseBaseDto;
import com.gy.daemon.lib.common.statecode.ServiceCode;
import com.gy.daemon.portal.service.TestCaseService;
import com.gy.daemon.portal.service.feignService.feignDto.TcInfoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by yang_gao on 2017/10/4.
 */

@RestController
@CrossOrigin(value = "*")
@RequestMapping("/tc")
public class TestCaseController {

    private static final Logger logger = LoggerFactory.getLogger(TestCaseController.class);

    @Autowired
    TestCaseService testCaseService;


    @GetMapping(value="/")
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

    @PostMapping(value="/")
    @Api(value = "createTc",desc = "创建一个TestCase")
    public BaseResponse<?> createTc(@RequestBody TcInfoEntity tcInfoEntity){
        logger.info("TestCaseController createTc begin");
        BaseResponse<TestCaseBaseDto> response=null;
        try {
            TestCaseBaseDto testCaseBaseDto = testCaseService.createTc(tcInfoEntity);
            if(null != tcInfoEntity){
                response = new BaseResponse<>(ServiceCode.SUCCESS,testCaseBaseDto);
            }else{
                logger.warn("TestCaseController createTc post result is null");
                response = new BaseResponse<>(ServiceCode.SERVICE_UNAVAILABLE,null);
            }
        } catch (Exception e) {
            logger.error("TestCaseController createTc catch exception: "+e.getMessage(),e);
            response = new BaseResponse<>(ServiceCode.SERVICE_UNAVAILABLE,null);
        }
        logger.info("TestCaseController createTc end");
        return response;
    }

    @DeleteMapping(value="/{tcId}")
    @Api(value="deleteTc",desc = "删除TestCase")
    public BaseResponse<?> deleteTc(@PathVariable("tcId")String tcId){
        logger.info("TestCaseController deleteTc begin");
        BaseResponse<List<TestCaseBaseDto>> response=null;
        try {
            testCaseService.deleteTestCaseById(tcId);
            response = new BaseResponse<>(ServiceCode.SUCCESS,null);
        } catch (Exception e) {
            logger.error("TestCaseController deleteTc catch exception: "+e.getMessage(),e);
            response = new BaseResponse<>(ServiceCode.SERVICE_UNAVAILABLE,null);
        }
        logger.info("TestCaseController deleteTc end");
        return response;
    }
}
