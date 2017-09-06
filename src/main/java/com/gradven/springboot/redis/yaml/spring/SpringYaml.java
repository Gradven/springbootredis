package com.gradven.springboot.redis.yaml.spring;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by liuhangjun on 2017/7/15.
 */
@Component
@ConfigurationProperties(prefix="spring")
public class SpringYaml {
    
    private ApplicationYaml application;
    
    
    public ApplicationYaml getApplication() {
        return application;
    }
    
    public void setApplication(ApplicationYaml application) {
        this.application = application;
    }
}
