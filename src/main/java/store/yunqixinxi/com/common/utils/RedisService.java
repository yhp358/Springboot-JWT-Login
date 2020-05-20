package store.yunqixinxi.com.common.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class RedisService {

    private static final Logger logger = LoggerFactory.getLogger(RedisService.class);

    @Autowired
    private RedisTemplate redisTemplate;


    /**
     * 写入到缓存
     * @param key
     * @param value
     * @return
     */
    public boolean set(String key,Object value){
        boolean result = false;

        try {
            redisTemplate.opsForValue().set(key,value);
        } catch (Exception e) {
            e.printStackTrace();
            result = false;
        }
        return true;
    }

    /**
     * 写入到缓存并设置过期时间
     * @param key
     * @param value
     * @param expireDate
     * @return
     */
    public boolean set(String key,Object value,Long expireDate){
        boolean result = false;

        try {
            redisTemplate.opsForValue().set(key,value);
            redisTemplate.expire(key,expireDate, TimeUnit.SECONDS);
        } catch (Exception e) {
            e.printStackTrace();
            result = false;
        }
        logger.info("成功存入token信息. {}",value);
        return true;
    }

    /**
     * 删除单个key
     * @param key
     */
    public void remove(final String key){
        redisTemplate.delete(key);
    }


    /**
     * 批量删除
     * @param keys
     */
    public void removeBatch(final String... keys){
        for (String key : keys) {
            remove(key);
        }

    }

    /**
     * 判断key是否存在
     * @param key
     * @return
     */
    public boolean exists(final String key){
        boolean result = false;
        if(redisTemplate.hasKey(key)){
            result = true;
        }
        return result;
    }

    /**
     * 获取缓存中的值
     * @param key
     * @return
     */
    public Object get(final String key){
        Object result = null;
        result = redisTemplate.opsForValue().get(key);
        return result;
    }

    /**
     * 获取指定key的过期时间
     * @param key
     * @return
     */
    public Long getexpire(String key){
        Long expire = redisTemplate.getExpire(key);
        return expire;
    }

    /**
     * 刷新过期时间
     * @param key
     * @return
     */
    public boolean setExpire(String key,Long expireTime){
        boolean result = false;
        redisTemplate.expire(key,expireTime,TimeUnit.SECONDS);
        result = true;
        return result;
    }
}
