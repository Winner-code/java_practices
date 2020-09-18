package com.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class JedisPoolTest {
    public static void main(String[] args) {
        testJedisPool();
    }
    public static void testJedisPool(){
        //创建连接池
        JedisPool pool = new  JedisPool("192.168.1.110", 6379);
        Jedis jedis = pool.getResource();
        String hres = jedis.hget("user","username");
        System.out.println(hres);
        jedis.close();
    }
}
