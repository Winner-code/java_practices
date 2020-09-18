package com.jedisdao;

public interface JedisDao {
	
	public String set(String key, String value);
	public String get(String key);
	public Long hset(String hkey, String key, String value);
	public String hget(String hkey, String key);
	public long expire(String key, int sec);
	public long del(String key);
}
