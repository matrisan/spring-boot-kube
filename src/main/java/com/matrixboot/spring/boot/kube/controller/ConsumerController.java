package com.matrixboot.spring.boot.kube.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;

/**
 * <p>
 * create in 2021/9/1 1:28 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */

@Slf4j
@RestController
public class ConsumerController implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        redisTemplate.opsForValue().set("hello", "works!");
    }

    @Resource
    private RedisTemplate<String, String> redisTemplate;

    @GetMapping("hello")
    public String hello() {
        String s = "Hello World! " + new Date();
        log.info(s);
        String hello = redisTemplate.opsForValue().get("hello");
        return s + "----" + hello;
    }

}
