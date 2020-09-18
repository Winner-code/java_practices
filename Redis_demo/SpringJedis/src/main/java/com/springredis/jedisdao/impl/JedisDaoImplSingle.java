package com.springredis.jedisdao.impl;

import com.springredis.jedisdao.JedisDao;
import org.springframework.beans.factory.annotation.Autowired;



import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;


public class JedisDaoImplSingle implements JedisDao {
	
	@Autowired
	private JedisPool jedisPool;
	

	@Override
	public String set(String key, String value) {
		Jedis jedis = this.jedisPool.getResource();
		return jedis.set(key, value);
	}

	@Override
	public String get(String key) {
		Jedis jedis = this.jedisPool.getResource();
		return jedis.get(key);
	}

	@Override
	public Long hset(String hkey, String key, String value) {
		Jedis jedis = this.jedisPool.getResource();
		return jedis.hset(hkey, key, value);
	}

	@Override
	public String hget(String hkey, String key) {
		Jedis jedis = this.jedisPool.getResource();
		return jedis.hget(hkey, key);
	}

}
