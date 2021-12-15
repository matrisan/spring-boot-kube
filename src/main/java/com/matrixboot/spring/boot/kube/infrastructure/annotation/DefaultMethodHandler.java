package com.matrixboot.spring.boot.kube.infrastructure.annotation;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.data.redis.connection.stream.ObjectRecord;
import org.springframework.data.redis.connection.stream.StreamRecords;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.util.Assert;

import java.util.Collection;

/**
 * <p>
 * create in 2021/12/15 4:21 PM
 *
 * @author shishaodong
 * @version 0.0.1
 */

public class DefaultMethodHandler implements InvocationHandlerFactory.MethodHandler {

    private final RedisStreamEndpointMeta meta;

    private final StringRedisTemplate stringRedisTemplate;

    private final ObjectMapper objectMapper;

    public DefaultMethodHandler(RedisStreamEndpointMeta meta, BeanFactory beanFactory) {
        this.meta = meta;
        this.stringRedisTemplate = beanFactory.getBean(StringRedisTemplate.class);
        this.objectMapper = beanFactory.getBean(ObjectMapper.class);
    }

    @Override
    public Object invoke(Object[] argv) {
        Assert.isTrue(argv.length == 1, "参数的个数必须为 1");
        Object oneArg = argv[0];
        if (oneArg instanceof Collection) {
            ((Collection<?>) oneArg).stream()
                    .map(this::serializer)
                    .forEach(o -> stringRedisTemplate.opsForStream().add(StreamRecords.newRecord().in(meta.getValue()).ofObject(o)));
            return ((Collection<?>) oneArg).size();
        } else {
            ObjectRecord<String, String> key = StreamRecords.newRecord()
                    .in(meta.getValue())
                    .ofObject(serializer(oneArg));
            stringRedisTemplate.opsForStream().add(key);
            return 1;
        }
    }

    @SneakyThrows
    private String serializer(Object o) {
        return objectMapper.writeValueAsString(o);
    }

}
