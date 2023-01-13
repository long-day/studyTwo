package me.longDay.reids_study;

import me.longDay.pojo.UserInfo;
import me.longDay.utils.LdObjectMapper;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

/**
 * @author 君
 * @version 1.0
 * @desc redis
 * @since 2023/1/12
 */
@SpringBootTest
public class HelloRedisTest {
    Logger log = LoggerFactory.getLogger(HelloRedisTest.class);
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Test
    void testString(){
        UserInfo user = new UserInfo("焰灵姬", 16);
        redisTemplate.opsForValue().set("焰灵姬",user);

        Object name = redisTemplate.opsForValue().get("焰灵姬");
        log.warn("获取的值 --> {}",name);
    }

    @Test
    void stringRedisTemplate(){
        UserInfo ylj = new UserInfo("焰灵姬", 16);
        try {
            String userInfo = LdObjectMapper.OBJECT_MAPPER.writeValueAsString(ylj);
            stringRedisTemplate.opsForValue().set("焰灵姬2",userInfo);

            UserInfo readValue = LdObjectMapper.OBJECT_MAPPER.readValue(stringRedisTemplate.opsForValue().get("焰灵姬2"), UserInfo.class);
            log.warn("read value ==> {}",readValue);

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
