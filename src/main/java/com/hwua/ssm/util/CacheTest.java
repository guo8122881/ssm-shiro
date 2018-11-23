package com.hwua.ssm.util;

import com.hwua.ssm.entity.User;
import com.hwua.ssm.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;

public class CacheTest {
    @Test
    public void test1(){
        ApplicationContext app=
                new ClassPathXmlApplicationContext("spring-config.xml");
        UserService service=app.getBean(UserService.class);
        User user=service.queryUserByName("admin");
        System.out.println(user);
        System.out.println("-------------------");
        User user2=service.queryUserByName("admin");
        System.out.println(user2);
    }

    @Test
    public void test12(){
        ApplicationContext app=
                new ClassPathXmlApplicationContext("spring-config.xml");
        RedisTemplate template=app.getBean(RedisTemplate.class);
        template.opsForValue().set("k1","v1");
    }

}
