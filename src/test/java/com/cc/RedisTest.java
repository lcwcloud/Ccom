package com.cc;

import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisMonitor;

public class RedisTest {
    @Test
    public void redisOp() {
        Jedis jedis = new Jedis("localhost");
//        jedis.set("foo", "bar");
//        System.out.println(jedis.get("foo"));
//
//        Set<HostAndPort> jedisClusterNodes = new HashSet<HostAndPort>();
//        jedisClusterNodes.add(new HostAndPort("127.0.0.1", 6379));
//        JedisCluster jedisCluster = new JedisCluster(jedisClusterNodes);
//        jedisCluster.set("foo", "bar");
//        System.out.println(jedisCluster.get("foo"));
        new Thread(new Runnable() {
            @Override
            public void run() {
                Jedis jedis = new Jedis("localhost");
                for (int i = 0; i < 100; i++) {
                    jedis.incr("foobared");
                    try {
                        Thread.sleep(200);
                    } catch (Exception e) {

                    }
                }
                jedis.disconnect();
            }
        }).start();
        jedis.monitor(new JedisMonitor() {
            @Override
            public void onCommand(String command) {
                System.out.println(command);
            }
        });
    }
}
