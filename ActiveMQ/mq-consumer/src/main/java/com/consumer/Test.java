package com.consumer;

public class Test {
    public static void main(String[] args) {
        HelloWorldConsumer consumer = new HelloWorldConsumer();
        consumer.readHelloWorldActiveMQ();

        HelloWorldConsumer2 helloWorldConsumer2 = new HelloWorldConsumer2();
        helloWorldConsumer2.readHelloWorldActiveMQ();
    }
}
