package com.gy.daemon.controller;

import com.gy.daemon.dao.UserDao;
import com.gy.daemon.dto.db.UserEntity;
import com.gy.daemon.lib.common.base.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by yang_gao on 2017/10/2.
 */
@RestController
public class UserControl {

    @Autowired
    UserDao userDao;

    @GetMapping(value = "/user")
    public BaseResponse<?> getUserByUid(@RequestParam("uid") Integer uid){
        BaseResponse<UserEntity> response = new BaseResponse<>();
        response.setResponseBody(userDao.queryUserByUid(uid));
        return response;
    }
}
