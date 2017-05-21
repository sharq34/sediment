package com.marcojan.sediment.redis;

import com.marcojan.sediment.redis.entity.User;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

import java.util.HashMap;
import java.util.UUID;

/**
 * Created by Marco on 06/05/2017.
 */
public class RedisSample {

    //单点直连
    private static Jedis jedis;
    //主从和哨兵模式使用Shard
    private static ShardedJedis shard;

    private static ShardedJedisPool pool;

    static{
        jedis = new Jedis("127.0.0.1", 6379);
    }

    public RedisSample() {

    }

    public void databaseRelatedRedis(){

        //User对象数据量很大，需要把关系数据库中的User记录放到缓存中去

        User u1 =new User(UUID.randomUUID().toString(),"31","u1","m");
        User u2 =new User(UUID.randomUUID().toString(),"32","u2","m");
        User u3 =new User(UUID.randomUUID().toString(),"33","u3","m");
        User u4 =new User(UUID.randomUUID().toString(),"34","u4","m");
        User u5 =new User(UUID.randomUUID().toString(),"35","u5","m");

        HashMap<String, String> users = new HashMap<>();

        users.put("u1",u1.toString());
        users.put("u2",u2.toString());
        users.put("u3",u3.toString());
        users.put("u4",u4.toString());
        users.put("u5",u5.toString());

        jedis.hmset("SYS_USER_TABLE",users);

        /**
         * Hash和set实现 select * from users 这样的关系数据库查询语句
         */
    }

    public static void main(String[] args) {
//        List<String> names = jedis.mget("name", "age");
//
//        for (String name :
//                names) {
//            System.out.println(name);
//
//        }

        new RedisSample().databaseRelatedRedis();
    }
}
