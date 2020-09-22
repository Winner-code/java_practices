package com.rabbit.direct;

import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

/**
 * 日志消息消费者，只消费Info日志。
 * 日志消息存储在队列 log-info-queue
 * 使用的交换器名称是 log-ex-direct
 * 交换器类型是 direct
 * 队列的路由键是 direct-rk-info
 *
 * 注解RabbitListener - 监听注解。可以描述类型和方法。
 *  类型 - 当前类型监听某个队列。
 *  方法 - 当前方法监听某个队列。
 *  属性 -
 *    bindings - QueueBinding[]类型，代表这个类型或方法监听的队列、交换器、路由键的绑定方式
 *
 * 注解QueueBinding -
 *  属性 -
 *    value - 绑定监听的队列是什么
 *    exchange - 队列对应的交换器是什么
 *    key - 队列的路由键是什么
 *
 * 注解Queue - 描述一个队列
 *  属性 -
 *    value|name - 队列名称
 *    autoDelete - 是否自动删除。默认为"", 如果队列名称定义，不自动删除；队列名称不定义，队列为自动删除队列。
 *      如果是自动删除，代表所有的consumer关闭后，队列自动删除。
 *
 * 注解Exchange - 描述一个交换器
 *  属性 -
 *    value|name - 交换器名称
 *    type - 交换器的类型，可选direct|fanout|topic， 默认direct
 *    autoDelete - 是否自动删除，默认为false。不自动删除。
 */
@RabbitListener(bindings = {
        @QueueBinding(
                value = @Queue(value = "log-info-queue",autoDelete = "false"),
                exchange = @Exchange(value = "log-ex-direct",type = "direct",autoDelete = "false"),
                key = "direct-rk-info"
    )
})
@Component
public class InfoLogConsumer {
    /**
     * 消息消费的方法。当队列log-info-queue中出现消息，立刻消费
     * RabbitHandler注解 - 配合类型上的RabbitListener注解，标记当前的方法，是一个监听消息队列，消费消息的方法。
     * @param msg 消息内容
     */
    @RabbitHandler
    public void onMessage(String msg){
        System.out.println("InfoLogConsumer 消费消息：" + msg);
    }
}
