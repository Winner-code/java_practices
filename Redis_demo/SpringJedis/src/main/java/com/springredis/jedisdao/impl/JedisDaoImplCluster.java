package com.springredis.jedisdao.impl;

import com.springredis.jedisdao.JedisDao;
import org.springframework.beans.factory.annotation.Autowired;



import redis.clients.jedis.JedisCluster;

public class JedisDaoImplCluster implements JedisDao {

	@Autowired
	private JedisCluster jedisCluster;
	
	@Override
	public String set(String key, String value) {
		return this.jedisCluster.set(key, value);
	}

	@Override
	public String get(String key) {
		return this.jedisCluster.get(key);
	}

	@Override
	public Long hset(String hkey, String key, String value) {
		return this.jedisCluster.hset(hkey, key, value);
	}

	@Override
	public String hget(String hkey, String key) {
		return this.jedisCluster.hget(hkey, key);
	}

}
