package com.test;

import redis.clients.jedis.Jedis;

public class TestServle {

	public static void main(String[] args) {
		Jedis jedis = new Jedis("127.0.0.1", 6378);
		String username = jedis.get("username");
		System.out.println(username);

	}

}
