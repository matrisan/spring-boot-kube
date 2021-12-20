package com.matrixboot.spring.boot.kube.interfaces.dto;

import lombok.Data;

/**
 * TODO
 * <p>
 * create in 2021/12/16 10:13 AM
 *
 * @author shishaodong
 * @version 0.0.1
 */
@Data
public class IdempotentCommand {

    private String username;

    private String password;

}
