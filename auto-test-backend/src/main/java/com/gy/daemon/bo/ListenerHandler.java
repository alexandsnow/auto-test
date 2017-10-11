package com.gy.daemon.bo;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * Created by yang_gao on 2017/10/10.
 */

@Component
public class ListenerHandler {

    @KafkaListener(topics = "AUTO_TEST")
    public String processMsg(String content){
        System.out.println("receive msg is: "+content);
        return content;
    }

}
