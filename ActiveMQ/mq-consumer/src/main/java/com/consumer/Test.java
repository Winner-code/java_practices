package com.consumer;

public class Test {
    public static void main(String[] args) {
//        HelloWorldConsumer consumer = new HelloWorldConsumer();
//        consumer.readHelloWorldActiveMQ();
//
//        HelloWorldConsumer2 helloWorldConsumer2 = new HelloWorldConsumer2();
//        helloWorldConsumer2.readHelloWorldActiveMQ();

        HelloWorldConsumer3 helloWorldConsumer3 = new HelloWorldConsumer3();
        helloWorldConsumer3.readHelloWorldActiveMQ();

        HelloWorldConsumerTopic1 topic1 = new HelloWorldConsumerTopic1();
        Thread t1 = new Thread(topic1);
        t1.start();

        HelloWorldConsumerTopic2 topic2 = new HelloWorldConsumerTopic2();
        Thread t2 = new Thread(topic2);
        t2.start();

        HelloWorldConsumerTopic3 topic3 = new HelloWorldConsumerTopic3();
        Thread t3 = new Thread(topic3);
        t3.start();

    }
}
