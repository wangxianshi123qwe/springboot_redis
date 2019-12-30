package com.redis.controll;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.redis.bean.Person;

@Controller
public class Inde {
	
	@RequestMapping("query")
	@ResponseBody
	public String query(@RequestBody Bean bean) {
		System.out.println("取值"+bean.getName());
		Person p = new Person("wxs", "成都");
		
		/*List<Object> list = new ArrayList<Object>();
		list.add(p);
		String jsonString = JSON.toJSONString(list);
		System.out.println(jsonString);*/
		return "success";
	}

}
