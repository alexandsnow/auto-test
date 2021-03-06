package com.gy.daemon.portal.service.feignService;

import com.gy.daemon.lib.common.base.BaseResponse;
import com.gy.daemon.portal.service.feignService.feignDto.TcInfoEntity;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by yang_gao on 2017/10/4.
 */

@FeignClient(value="auto-test-backend")
public interface TcFeignService {

    @RequestMapping(value="/tc/",method = RequestMethod.GET)
    BaseResponse<List<TcInfoEntity>> getAllTc();

    @RequestMapping(value="/tc/",method = RequestMethod.POST)
    BaseResponse<TcInfoEntity> createTc(@RequestBody TcInfoEntity tcInfoEntity);

    @RequestMapping(value="/tc/{tcId}",method = RequestMethod.DELETE)
    BaseResponse<Object> deleteTc(@PathVariable("tcId")String tcId);
}
