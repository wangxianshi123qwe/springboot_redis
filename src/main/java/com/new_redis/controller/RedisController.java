package com.new_redis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.new_redis.service.NewRedisService;

@RestController
public class RedisController {
	
	@Autowired
	private NewRedisService redisService;
	
	@RequestMapping("/put")
	public String put(String key,String value) {
		redisService.setString(key, value);
		return  "sccess";
	}
	
	@RequestMapping("/getKey")
	public String getKey(String key) {
		return redisService.getString(key);
	}
	
}
