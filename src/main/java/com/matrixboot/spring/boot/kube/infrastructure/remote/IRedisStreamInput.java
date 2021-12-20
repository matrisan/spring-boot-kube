package com.matrixboot.spring.boot.kube.infrastructure.remote;

import com.matrixboot.redis.annotation.RedisStreamClient;
import com.matrixboot.redis.annotation.RedisStreamEndpoint;
import com.matrixboot.spring.boot.kube.interfaces.dto.IdempotentCommand;

/**
 * <p>
 * create in 2021/12/15 7:25 PM
 *
 * @author shishaodong
 * @version 0.0.1
 */
@RedisStreamClient("client")
public interface IRedisStreamInput {

    /**
     * 推送数据
     *
     * @param versioned 版本
     */
    @RedisStreamEndpoint("test_key")
    void stream(IdempotentCommand versioned);

}
