package com.example.demo.mybatis.cache;

import org.apache.ibatis.cache.Cache;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class RedisCache implements Cache {
    @Override
    public String getId() {
        return null;
    }

    @Override
    public void putObject(Object o, Object o1) {

    }

    @Override
    public Object getObject(Object o) {
        return null;
    }

    @Override
    public Object removeObject(Object o) {
        return null;
    }

    @Override
    public void clear() {

    }

    @Override
    public int getSize() {
        return 0;
    }

    @Override
    public ReadWriteLock getReadWriteLock() {
        return null;
    }
  /*  private final String id;

    private static ValueOperations<String, Object> valueOs;

    private static RedisTemplate<String, String> template;


    public static void setValueOs(ValueOperations<String, Object> valueOs) {
        RedisCache.valueOs = valueOs;
    }

    public static void setTemplate(RedisTemplate<String, String> template) {
        RedisCache.template = template;
    }

    private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();


    public RedisCache(String id) {
        if (id == null) {
            throw new IllegalArgumentException("Cache instances require an ID");
        }
        this.id = id;
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public void putObject(Object key, Object value) {
        valueOs.set(key.toString(), value, 10, TimeUnit.MINUTES);
    }

    @Override
    public Object getObject(Object key) {
        return valueOs.get(key.toString());
    }

    @Override
    public Object removeObject(Object key) {
        valueOs.set(key.toString(), "", 0, TimeUnit.MINUTES);
        return key;
    }

    @Override
    public void clear() {
        template.getConnectionFactory().getConnection().flushDb();
    }

    @Override
    public int getSize() {
        return template.getConnectionFactory().getConnection().dbSize().intValue();
    }

    @Override
    public ReadWriteLock getReadWriteLock() {
        return this.readWriteLock;
    }
*/
}
