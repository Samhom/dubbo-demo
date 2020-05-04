package com.ly.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.ly.mapper.UserMapper;
import com.ly.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service(timeout=3000)	//3秒超时	
public class UserServiceImpl implements UserService {
	@Autowired
	private UserMapper userMapper;
	@Override
	public List<User> findAll() {
		
		System.out.println("我是第一个服务的提供者");
		return userMapper.selectList(null);
	}
	@Override
	public void saveUser(User user) {
		
		userMapper.insert(user);
	}
}
