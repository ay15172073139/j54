package org.java.jedis;

public interface JedisClient {
    void set(String key,String val);
    String get(String key);

    void hset(String key,String field,String val);
    String hget(String key,String field);
}
