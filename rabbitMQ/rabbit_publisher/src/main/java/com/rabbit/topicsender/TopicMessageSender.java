package com.rabbit.topicsender;

        import org.springframework.amqp.core.AmqpTemplate;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Component;
/**
 * 发送消息到主题交换器
 */
@Component
public class TopicMessageSender {
    @Autowired
    private AmqpTemplate template;

    /**
     * 发送消息的方法
     * @param exchange
     * @param routingKey
     * @param message
     */
    public void send(String exchange, String routingKey, String message){
        template.convertAndSend(exchange, routingKey, message);
    }
}
