package com.new_redis.service;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


/**
 * 
 * 	<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-redis</artifactId>
		</dependency>
 * map 和list存放对象，首先把list和map转为json后，通过sting类型来存放
 * 
 * @author Administrator
 *
 */
@Component
public class NewRedisService {
	@Autowired
	private StringRedisTemplate stringRedisTemplate;

	public void setString(String key, Object value) {
		setObject(key, value, null);
	}

	public void setString(String key, Object value, Long time) {
		setObject(key, value, time);
	}

	public void setList(String key, List<String> list) {
		setObject(key, list, null);
	}

	public void setList(String key, List<String> valueList, Long time) {
		setObject(key, valueList, time);
	}

	public void setMap(String key, Map<String, Object> map) {
		setObject(key, map, null);
	}
	public void setMap(String key, Map<String, Object> map, Long time) {
		setObject(key, map, time);
	}

	// time,设置数据在redis保存时间
	public void setObject(String key, Object value, Long time) {
		if (StringUtils.isEmpty(key) || value == null) {
			return;
		}

		if (value instanceof String) {
			if (time != null) {
				stringRedisTemplate.opsForValue().set(key, (String) value, time, TimeUnit.SECONDS);
			} else {
				stringRedisTemplate.opsForValue().set(key, (String) value);
			}
			return;
		}

		if (value instanceof List) {
			// 存放list類型
			/*
			 * List<String> listValue = (List<String>) value; for (String string :
			 * listValue) { stringRedisTemplate.opsForList().leftPush(key, string); }
			 */
			List obj = (List) value;
			stringRedisTemplate.opsForList().leftPushAll(key, obj);
			stringRedisTemplate.expire(key, time, TimeUnit.SECONDS);
		}

		if (value instanceof Map) {
			HashOperations<String, String, Object> opsForHash = stringRedisTemplate.opsForHash();
			opsForHash.putAll(key, (Map) value);
			stringRedisTemplate.expire(key, time, TimeUnit.SECONDS);// 设置超时时间10秒 第三个参数控制时间单位，
		}

	}
	// 封装map,set,排序set

	public boolean existKey(String key) {
		return stringRedisTemplate.hasKey(key);
	}

	public void delKey(String key) {
		stringRedisTemplate.delete(key);
	}

	public String getString(String key) {
		boolean flage = existKey(key);
		if (flage) {
			return stringRedisTemplate.opsForValue().get(key);
		} else {
			return null;
		}
	}

	public List<String> getListValue(String key) {
		boolean flage = existKey(key);
		if (flage) {
			return stringRedisTemplate.opsForList().range(key, 0, -1);// -1,表示所有的元素
		} else {
			return null;
		}
	}

	public Map<String, Object> getMapValue(String key) {
		boolean flage = existKey(key);
		if (flage) {
			HashOperations<String, String, Object> hps = stringRedisTemplate.opsForHash();
			return hps.entries(key);
		} else {
			return null;
		}

	}
}
