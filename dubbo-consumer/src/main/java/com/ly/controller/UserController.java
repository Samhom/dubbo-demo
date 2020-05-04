package com.ly.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ly.pojo.User;
import com.ly.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class UserController {
	
	/**
	 * check:true 检查是否有服务的提供者
	 * 先启动服务提供者,之后启动消费者
	 */
	@Reference(timeout=3000,check=true,loadbalance = "leastactive")
	private UserService userService;
	
	@RequestMapping("/findAll")
	public List<User> findAll(){
		
		return userService.findAll();
	}
	
	@RequestMapping("/saveUser/{name}/{age}/{sex}")
	public String saveUser(User user) {
		
		userService.saveUser(user);
		return "用户入库成功!!!";
	}
}
