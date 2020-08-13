package com.rabbit.topic;

import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 主题消息消费者。
 */
@Component
public class TopicConsumer {
    /**
     * 短信消息消费者，对应的routingKey是 user.rk.sms | order.rk.sms | pay.rk.sms | reg.rk.sms 等。
     * 分别代表，用户登录短信|订单下订成功通知短信|支付成功通知短信|注册码通知短信 等。
     */
    @RabbitListener(bindings = {
            @QueueBinding(
                    value = @Queue(value = "queue-sms-topic", autoDelete = "false"),
                    exchange = @Exchange(value = "ex-topic", type = "topic"),
                    key = "*.rk.sms"
            )
    })
    public void onUserSMSMessage(String message){
        System.out.println("用户短信消息内容是：" + message);
    }

    /**
     * 路由键包括： user.rk.email | reg.rk.email | pay.rk.email
     * @param message
     */
    @RabbitListener(bindings = {
            @QueueBinding(
                    value = @Queue(value = "queue-email-topic", autoDelete = "false"),
                    exchange = @Exchange(value = "ex-topic", type = "topic"),
                    key = "*.rk.email"
            )
    })
    public void onUserEmailMessage(String message){
        System.out.println("用户邮件消息内容是：" + message);
    }

    /**
     * 所有的和 rk相关的消息，统一处理消费。
     * 包含的路由键有： user.rk.sms | user.rk.email | reg.rk.sms | reg.rk.email 等。
     * 不发短信，不发邮件，作为一个日志记录工具存在。
     * @param message
     */
    @RabbitListener(bindings = {
            @QueueBinding(
                    value = @Queue(value = "queue-all-topic", autoDelete = "false"),
                    exchange = @Exchange(value = "ex-topic", type = "topic"),
                    key = "*.rk.*"
            )
    })
    public void onUserServiceMessage(String message){
        System.out.println("执行的消息处理逻辑是：" + message);
    }
}
