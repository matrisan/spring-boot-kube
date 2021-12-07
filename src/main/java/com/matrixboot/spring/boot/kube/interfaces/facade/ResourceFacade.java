package com.matrixboot.spring.boot.kube.interfaces.facade;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * create in 2021/12/7 7:54 PM
 *
 * @author shishaodong
 * @version 0.0.1
 */
@RestController
public class ResourceFacade {

    @Value("classpath:data.txt")
    private Resource resource;

    @GetMapping("123")
    public List<String> string() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(resource.getInputStream()));
        String s = bufferedReader.readLine();
        List<String> strings = new ArrayList<>();
        while (StringUtils.hasText(s)) {
            strings.add(s);
            s = bufferedReader.readLine();
        }
        return strings;
    }
}
