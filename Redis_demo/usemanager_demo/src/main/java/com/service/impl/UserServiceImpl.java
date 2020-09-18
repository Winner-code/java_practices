package com.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.commons.JsonUtils;
import com.jedisdao.JedisDao;
import com.mapper.UserMapper;
import com.pojo.Users;
import com.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;

	@Autowired
	private JedisDao jedisDao;

	@Value("${REDIS_USERS_PRIFX}")
	private String REDIS_USERS_PRIFX;

	@Override
	public void addUser(Users users) {
		this.userMapper.insertUser(users);
	}

	@Override
	public Users findUserById(int userid) {
		try {
			// 查询缓存
			String json = this.jedisDao.get(this.REDIS_USERS_PRIFX + ":" + userid);
			// 在缓存中是否命中
			if (json != null && json.length() > 0) {
				System.out.println(".........................");
				Users user = JsonUtils.jsonToPojo(json, Users.class);
				return user;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 查询数据库
		Users user = this.userMapper.findUserById(userid);
		System.out.println(",,,,,,,,,,,,,,,,,,,,,,,,,,,,,");
		try {
			// 放入到redis中
			String res = JsonUtils.objectToJson(user);
			this.jedisDao.set(this.REDIS_USERS_PRIFX + ":" + userid, res);
			this.jedisDao.expire(this.REDIS_USERS_PRIFX + ":" + userid, 60);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public void updateUser(Users users) {
		this.userMapper.updateUser(users);
		try{
			//同步redis
			this.jedisDao.del(this.REDIS_USERS_PRIFX+":"+users.getUserid());
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
