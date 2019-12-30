package com.redis.controll;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.redis.bean.Person;
import com.redis.service.JSONSerializer;
import com.redis.service.RedisService;

import ch.qos.logback.core.net.SyslogOutputStream;

@RestController
public class IndexController {
	@Autowired
	private RedisService redisService;
	
	@RequestMapping("/getport2")
	public String getPort() {
		return "8080";
	}
	
	@RequestMapping("/add")
	public String add(String key) {
		System.out.println("取值"+key);
		redisService.setString("wxs", "hello redis");
		return "success";
	}
	@RequestMapping("/getString")
	public String getStrign(String key) {
		String string = redisService.getString("wxs");
		return string;
	}
	@RequestMapping("/setMap")
	public String setMap() {
		Person p = new Person("wxs", "成都");
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("obj", p);
		System.out.println("============存值==============");
		redisService.setMap("map", map);
		System.out.println("===============取值==================");
		Map<String, Object> mapValue = redisService.getMapValue("map");
		Set<String> keySet = mapValue.keySet();
		for (String srt:keySet) {
			System.out.println(srt);
			Person person = (Person)mapValue.get(srt);
			System.out.println(person.getAddress());
		}
		return "success";
	}
	@RequestMapping("/setList")
	public String setList() {
		Person p = new Person("wxs", "成都");
		List<Object> list = new ArrayList<Object>();
		list.add(p);
		String jsonString = JSON.toJSONString(list);
		redisService.setString("list", jsonString);
		System.out.println(jsonString);
		List<Person> userList = JSON.parseArray(redisService.getString("list"),Person.class);
		for (int i=0; i<userList.size(); i++) {
			Person person = userList.get(i);
			System.out.println(person.getAddress());
		}
		return "成功";
	}
}
