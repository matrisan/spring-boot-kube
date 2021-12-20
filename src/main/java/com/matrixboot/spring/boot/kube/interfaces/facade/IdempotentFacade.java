package com.matrixboot.spring.boot.kube.interfaces.facade;

import com.matrixboot.idempotent.annotation.Idempotent;
import com.matrixboot.spring.boot.kube.infrastructure.remote.IRedisStreamInput;
import com.matrixboot.spring.boot.kube.interfaces.dto.IdempotentCommand;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 * create in 2021/12/16 10:11 AM
 *
 * @author shishaodong
 * @version 0.0.1
 */
@RestController
public class IdempotentFacade {

    @Resource
    private IRedisStreamInput redisStreamInput;

    @PostMapping("idempotent1")
    @Idempotent(value = "#command.username")
    public IdempotentCommand idempotent1(@RequestBody IdempotentCommand command) {
        redisStreamInput.stream(command);
        return command;
    }

    @PostMapping("idempotent2")
    @Idempotent(value = "@idempotentService.convert(#command)", timeout = 30, unit = TimeUnit.SECONDS)
    public IdempotentCommand idempotent2(@RequestBody IdempotentCommand command) {
        return command;
    }

}
