package com.spring.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedisTest {
	public static JedisPoolConfig c = new JedisPoolConfig(); // 连接池配置
    public static JedisPool jedisPool = null; // 连接池
    
   static {
        c.setBlockWhenExhausted(true); // 连接耗尽则阻塞
        c.setLifo(true); // 后进先出
        c.setMaxIdle(10); // 最大空闲连接数为10
        c.setMinIdle(0); // 最小空闲连接数为0
        c.setMaxTotal(20); // 最大连接数为20
        c.setMaxWaitMillis(-1); // 设置最大等待毫秒数：无限制
        c.setMinEvictableIdleTimeMillis(1800000); // 逐出连接的最小空闲时间：30分钟
        c.setTestOnBorrow(false); // 获取连接时是否检查连接的有效性：是
        c.setTestWhileIdle(true); // 空闲时是否检查连接的有效性：是
        
        jedisPool = new JedisPool(c, "10.1.8.2", 6379); // 初始化连接池
    }
    
    /**
     * 获取Jedis连接
     * @return Jedis连接
     */
    public static Jedis getJedis() {
        return jedisPool.getResource();
    }
	public static void main(String[] args) {
		
		Jedis jedis = null;
		try {
			// 连接redis
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
