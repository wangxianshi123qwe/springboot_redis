package com.redis.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

import com.alibaba.fastjson.JSON;

public class JSONSerializer {
	private static final String DEFAULT_CHARSET_NAME = "UTF-8";

	//对象转为json
	public static <T> String toJSONString(T object) {
		return JSON.toJSONString(object);
	}

	//json转为对象
	public static <T> T parseObject(String string, Class<T> clz) {
		return JSON.parseObject(string, clz);
	}

	//jsonArray转为list(List转为json后再转为list的方法)
	public static List JSONArrayToList(String jsonArray,Class clz){
		return JSON.parseArray(jsonArray,clz);
	}
	
	public static <T> T load(Path path, Class<T> clz) throws IOException {
		return parseObject(new String(Files.readAllBytes(path), DEFAULT_CHARSET_NAME), clz);
	}

	public static <T> void save(Path path, T object) throws IOException {
		if (Files.notExists(path.getParent())) {
			Files.createDirectories(path.getParent());
		}
		Files.write(path, toJSONString(object).getBytes(DEFAULT_CHARSET_NAME), StandardOpenOption.WRITE,
				StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
	}
}
