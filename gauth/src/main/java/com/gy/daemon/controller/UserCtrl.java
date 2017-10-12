package com.gy.daemon.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

/**
 * Created by yang_gao on 2017/10/12.
 * Query,Put,Delete
 */

@RestController
@RequestMapping({"/v1","/user"})
public class UserCtrl {

    @GetMapping("/")
    public String getAllUser(){
        return "give you all user!";
    }

    @DeleteMapping(value = "/{userId}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public int deleteUser(@PathVariable("userId")String userId){
        System.out.println("execute the delete operation");
        return 0;
    }

}
