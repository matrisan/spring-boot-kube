package com.matrixboot.spring.boot.kube.infrastructure;

import com.matrixboot.spring.boot.kube.domain.UserInfoEntity;
import com.matrixboot.spring.boot.kube.infrastructure.annotation.RedisStreamClient;
import com.matrixboot.spring.boot.kube.infrastructure.annotation.RedisStreamEndpoint;

/**
 * <p>
 * create in 2021/12/14 10:20 PM
 *
 * @author shishaodong
 * @version 0.0.1
 */
@RedisStreamClient("client")
public interface RedisStreamAccess {

    @RedisStreamEndpoint("test_key")
    int stream(UserInfoEntity entity);

}
