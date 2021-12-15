package com.matrixboot.spring.boot.kube.interfaces.facade;

import com.matrixboot.spring.boot.kube.infrastructure.RedisStreamAccess;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
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
public class ConsumerFacade implements CommandLineRunner {

    @Resource
    private RedisTemplate<String, String> redisTemplate;

    @Resource
    private RedisStreamAccess redisStreamAccess;

    @GetMapping("hello")
    public String hello() {
        String s = "Hello World! " + new Date();
        log.info(s);
        String hello = redisTemplate.opsForValue().get("hello");
        return s + "----" + hello;
    }

    @PostMapping("upload")
    public String upload(@RequestParam("file") MultipartFile file) throws IOException {
        file.transferTo(new File("/tmp/file-" + new Date()));
        return "success";
    }

    @Override
    public void run(String... args) throws Exception {
        redisTemplate.opsForValue().set("hello", "works!");
    }

}
