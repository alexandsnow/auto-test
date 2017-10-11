package com.gy.daemon.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

/**
 * Created by yang_gao on 2017/10/10.
 */

@Component
public class MsgProducerBo {


    public static final String DEFAULT_TOPIC = "AUTO_TEST";

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;


    public void sendMsg(String msg) {
        this.sendMsg(DEFAULT_TOPIC, msg);
    }

    public void sendMsg(String topic, String msg) {
        kafkaTemplate.send(topic, msg);
    }
}
