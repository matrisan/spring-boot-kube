package com.matrixboot.spring.boot.kube.domain.service;

import com.matrixboot.spring.boot.kube.interfaces.dto.IdempotentCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * <p>
 * create in 2021/12/16 2:50 PM
 *
 * @author shishaodong
 * @version 0.0.1
 */
@Slf4j
@Service
@SuppressWarnings("unused")
public class IdempotentService {

    public String convert(IdempotentCommand command) {
        log.info("IdempotentService:{}", command);
        return command.getUsername() + command.getPassword();
    }

}
