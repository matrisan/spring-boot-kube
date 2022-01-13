package com.matrixboot.spring.boot.kube.application.service;

import com.matrixboot.spring.boot.kube.interfaces.facade.ResourceFacade;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * TODO
 * <p>
 * create in 2022/1/10 10:03 AM
 *
 * @author shishaodong
 * @version 0.0.1
 */
@Service
public class ContainerService {

    @Resource
    private ResourceFacade resourceFacade;

}
