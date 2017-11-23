package com.spring.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedisTest {
	public static JedisPoolConfig c = new JedisPoolConfig(); // ���ӳ�����
    public static JedisPool jedisPool = null; // ���ӳ�
    
   static {
        c.setBlockWhenExhausted(true); // ���Ӻľ�������
        c.setLifo(true); // ����ȳ�
        c.setMaxIdle(10); // ������������Ϊ10
        c.setMinIdle(0); // ��С����������Ϊ0
        c.setMaxTotal(20); // ���������Ϊ20
        c.setMaxWaitMillis(-1); // �������ȴ���������������
        c.setMinEvictableIdleTimeMillis(1800000); // ������ӵ���С����ʱ�䣺30����
        c.setTestOnBorrow(false); // ��ȡ����ʱ�Ƿ������ӵ���Ч�ԣ���
        c.setTestWhileIdle(true); // ����ʱ�Ƿ������ӵ���Ч�ԣ���
        
        jedisPool = new JedisPool(c, "10.1.8.2", 6379); // ��ʼ�����ӳ�
    }
    
    /**
     * ��ȡJedis����
     * @return Jedis����
     */
    public static Jedis getJedis() {
        return jedisPool.getResource();
    }
	public static void main(String[] args) {
		
		Jedis jedis = null;
		try {
			// ����redis
			// jedis = new Jedis("10.1.8.2", 6379);
			jedis = RedisTest.getJedis();
			jedis.auth("redis123");
			jedis.set("redis", "redis1");
			String redis = jedis.get("redis");
			System.out.println(redis);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(jedis!=null){
				jedis.close();
			}
		}
	}

}
