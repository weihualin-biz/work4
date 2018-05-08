package com.biz.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import com.biz.po.Student;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Tuple;

public class Tools {
	
	//查询指定页数的数据
	public static List<Student> queryStudentByPage(int pageNum) {
		List<Student> list=new ArrayList<Student>();
		Jedis jedis=RedisUtils.getJedis();
		Set<Tuple> set= jedis.zrevrangeWithScores("student", (pageNum-1)*10, pageNum*10-1);
		if(set!=null&&set.size()>0) {
			for(Tuple t:set) {
				double score=t.getScore();
				int avgscore=(int)score;
				String value=t.getElement();
				String[] values=value.split("~-");
				Student student=new Student();
				student.setavgscore(avgscore);
				student.setId(values[0]);
				student.setName(values[1]);
				student.setBirthday(values[2]);
				student.setDescription(values[3]);
				list.add(student);
			}
		}
		
		
		return list;
	}
	
	//删除数据
	public static void deleteStudent(String str) {
		Jedis jedis=RedisUtils.getJedis();
		jedis.zrem("student", str);
	}
	public static void insertStudent(double score,String member) {
		Jedis jedis=RedisUtils.getJedis();
		jedis.zadd("student", score, member);
		
	}
	//获取总页数
	public static long getPageNum() {
		Jedis jedis=RedisUtils.getJedis();
		long number=jedis.zcard("student");
		long p=0L;
		if(number%10==0) {
			p=number/10;
		}else {
			p=number/10+1;
		}
		return p;
	}

}
