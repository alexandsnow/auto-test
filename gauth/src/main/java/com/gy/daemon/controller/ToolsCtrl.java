package com.gy.daemon.controller;

import com.gy.daemon.dto.ToolsDto;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by yang_gao on 2017/10/12.
 */

@RestController
@RequestMapping("/tool")
public class ToolsCtrl {


    @GetMapping(value = "/bcrypt")
    public String encrypt(@RequestParam("text")String text){
        ToolsDto.BCryptDto bCryptDto = new ToolsDto.BCryptDto();
        bCryptDto.setOriText(text);
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        bCryptDto.setCipher(encoder.encode(text));
        return bCryptDto.toString();
    }
}
