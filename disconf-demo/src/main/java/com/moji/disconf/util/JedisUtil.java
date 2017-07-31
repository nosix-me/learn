package com.moji.disconf.util;

import redis.clients.jedis.Jedis;

public class JedisUtil {
	public static Jedis createJedis(String host, Integer port, String password) {
		Jedis jedis = new Jedis(host, port);
		jedis.auth(password);
		return jedis;
	}
}
