package com.example.topic;

import com.example.config.TopicRabbitConfig;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TopSender {

    @Autowired
    private AmqpTemplate amqpTemplate;

    public void send(){
        String str = "need string";
        this.amqpTemplate.convertAndSend(TopicRabbitConfig.topicExchange,"topic.1",str);
    }
}
