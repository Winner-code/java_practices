package com.rabbit.direct;

import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 日志消息消费者，消费error和warn日志。
 * error日志消息存储在队列 log-error-queue
 * warn日志消息存储在队列 log-warn-queue
 * 使用的交换器名称是 log-ex-direct
 * 交换器类型是 direct
 * error队列的路由键是 direct-rk-error
 * warn队列的路由键是 direct-rk-warn
 */
@Component
public class LogConsumer {
    @RabbitListener(bindings = {
            @QueueBinding(
                    value = @Queue(value = "log-error-queue"),
                    exchange = @Exchange(value = "log-ex-direct"),
                    key = "direct-rk-error"
            )
    })
    public void onLogErrorMessage(String msg){
        System.out.println("错误日志信息：" + msg);
    }

    @RabbitListener(bindings = {
            @QueueBinding(
                    value = @Queue(value = "log-warn-queue", autoDelete = "false"),
                    exchange = @Exchange(value = "log-ex-direct"),
                    key = "direct-rk-warn"
            )
    })
    public void onLogWarnMessage(String msg){
        System.out.println("警告日志信息：" + msg);
    }
}
