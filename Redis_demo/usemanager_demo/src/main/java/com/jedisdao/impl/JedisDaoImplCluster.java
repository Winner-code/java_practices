package com.jedisdao.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.jedisdao.JedisDao;

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

	@Override
	public long expire(String key, int sec) {
		return this.jedisCluster.expire(key, sec);
	}

	@Override
	public long del(String key) {
		return this.jedisCluster.del(key);
	}

}
