package com.matrixboot.spring.boot.kube.interfaces.facade;

import com.matrixboot.spring.boot.kube.domain.UserInfoEntity;
import com.matrixboot.spring.boot.kube.infrastructure.RedisStreamAccess;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * TODO
 * <p>
 * create in 2021/12/15 4:58 PM
 *
 * @author shishaodong
 * @version 0.0.1
 */
@Slf4j
@RestController
public class RedisStreamController {

    @Resource
    private RedisStreamAccess redisStreamAccess;

    @PostMapping("stream")
    public String hello(@RequestBody UserInfoEntity entity) {
        int hello = redisStreamAccess.stream(entity);
        return entity + "----" + hello;
    }

}
