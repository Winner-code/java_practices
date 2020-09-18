package com.redis;

import redis.clients.jedis.Jedis;

public class JedisTest {
    public static void main(String[] args) {
        testJedisSingle();
    }

    /**
     * 单机版Redis
     */
    public static void testJedisSingle(){
        //创建接地时对象
        Jedis jedis = new Jedis("192.168.1.110", 6379);
        //调用jedis的API完成对Redis的操作。jedis中方法名和Redis相同
        String set = jedis.set("key1", "value1");
        System.out.println(set);

        String key1 = jedis.get("key1");
        System.out.println(key1);

        System.out.println("-----------------------------");

        Long l = jedis.hset("user", "username","kevin");
        System.out.println(l);

        String hres = jedis.hget("user","username");
        System.out.println(hres);
        jedis.close();

    }
}
