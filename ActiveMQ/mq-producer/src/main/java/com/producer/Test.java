package com.producer;

public class Test {
    public static void main(String[] args) {
//        HelloWorldProducer producer = new HelloWorldProducer();
//        producer.sendHelloWorldActiveMQ("HelloWorld");
//
//        Users users = new Users();
//        users.setUserage(22);
//        users.setUserid(1);
//        users.setUsername("zhangsan");
//        HelloWorldProducer2 helloWorldProducer2 = new HelloWorldProducer2();
//        helloWorldProducer2.sendHelloWorldActiveMQ(users);

//        HelloWorldProducer3 producer3 = new HelloWorldProducer3();
//        producer3.sendHelloWorldActiveMQ("Hello Admin");

        HelloWorldProducerTopic topic = new HelloWorldProducerTopic();
        topic.sendHelloWorldActiveMQ("Hello Topic");

    }
}
