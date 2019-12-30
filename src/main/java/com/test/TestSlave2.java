package com.test;

import redis.clients.jedis.Jedis;

public class TestSlave2 {

	public static void main(String[] args) {
		Jedis jedis = new Jedis("127.0.0.1", 6380);
		String username = jedis.get("username");
		System.out.println(username);

	}

}
