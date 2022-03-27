package com.matrixboot.spring.boot.kube.interfaces.facade;

import com.matrixboot.spring.boot.kube.interfaces.dto.IdempotentCommand;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * create in 2021/12/16 10:11 AM
 *
 * @author shishaodong
 * @version 0.0.1
 */
@RestController
public class IdempotentFacade {


    @PostMapping("idempotent1")
    public IdempotentCommand idempotent1(@RequestBody IdempotentCommand command) {
        return command;
    }

    @PostMapping("idempotent2")
    public IdempotentCommand idempotent2(@RequestBody IdempotentCommand command) {
        return command;
    }

}
