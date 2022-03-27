package com.matrixboot.spring.boot.kube;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author shishaodong
 */
@EnableAspectJAutoProxy
@SpringBootApplication
public class SpringBootKubeApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootKubeApplication.class, args);
    }

}
