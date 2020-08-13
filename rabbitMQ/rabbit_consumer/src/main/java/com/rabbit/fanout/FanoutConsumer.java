package com.rabbit.fanout;

import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;
import com.entity.User;
/**
 * 广播交换器，消费者
 */
@Component
public class FanoutConsumer {
    /**
     * 消费消息的方法
     * @param user 消息体内容
     */
    @RabbitListener(bindings = {
            @QueueBinding(
                    value = @Queue(value = "queue-user-1" ,autoDelete = "false"),
                    exchange = @Exchange(value = "ex-fanout",type = "fanout",autoDelete = "false")
            )
    })
    public void onMessage(User user){
        System.out.println("onMessage1 run:"+user);
    }
    @RabbitListener(bindings = {
            @QueueBinding(
                    value = @Queue(value = "queue-user-2" ,autoDelete = "false"),
                    exchange = @Exchange(value  = "ex-fanout",type = "fanout",autoDelete = "false")
            )
    })
    public void onMessage1(User user){
        System.out.println("onMessage2 run:"+user);
    }
}
