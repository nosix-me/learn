package com.moji.apollo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class TestRedis {

	public static void main(String[] args) {
		ApplicationContext ctx = getProductModeApplicationContext();
		JedisPool jedisPool = ctx.getBean("weatherSlaveRedis", redis.clients.jedis.JedisPool.class);
		Jedis jedis = jedisPool.getResource();
		System.out.println(jedis.get("name"));
	}
	
	private static ApplicationContext getProductModeApplicationContext() {
		String[] locations = new String[] { "classpath:application_redis.xml"};
		ApplicationContext ctx = new ClassPathXmlApplicationContext(locations);
		return ctx;
	}
}
