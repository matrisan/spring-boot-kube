package com.matrixboot.spring.boot.kube;

import com.matrixboot.spring.boot.kube.infrastructure.annotation.EnableRedisStreamClients;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author shishaodong
 */
@EnableRedisStreamClients
@SpringBootApplication
public class SpringBootKubeApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootKubeApplication.class, args);
    }

}
