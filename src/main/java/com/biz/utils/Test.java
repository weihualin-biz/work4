package com.biz.utils;

import java.util.Set;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Tuple;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Jedis jedis=RedisUtils.getJedis();
		Set<Tuple> set=jedis.zrevrangeWithScores("student", 0, 9);
		for(Tuple t:set) {
			System.out.print(t.getScore()+"   ");
			System.out.println(t.getElement());
		}
		

	}

}
