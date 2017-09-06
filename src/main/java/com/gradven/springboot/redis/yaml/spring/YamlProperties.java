package com.gradven.springboot.redis.yaml.spring;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.util.Properties;

/**
 * Created by liuhangjun on 2017/7/17.
 */
public class YamlProperties {
    
    private static org.slf4j.Logger logger = LoggerFactory.getLogger(YamlProperties.class);
    
    private static String captchaProjectMode;
    
    private static String springProfilesActive;
    
    private static String getSpringProfilesActive(){
        
        if (springProfilesActive != null)
            return springProfilesActive;
        
        String key = "spring.profiles.active";
        
        String profile = System.getenv(key);
        if (profile == null)
            profile = System.getProperty(key);
        
        if(profile == null) {
    
            YamlPropertiesFactoryBean propertiesFactoryBean = new YamlPropertiesFactoryBean();
    
            Resource resource = new ClassPathResource("config/application.yml");
            propertiesFactoryBean.setResources(resource);
            Properties properties = propertiesFactoryBean.getObject();
    
            profile = properties.getProperty(key);
        }
    
        springProfilesActive = profile;
        logger.info("=========spring.profiles.active===========: " + profile);
        
        return profile;
    }
    
    
    /**
     * 读取yaml文件内容
     * @param key
     * @return
     */
    public static String getProperty(String key){
        
        YamlPropertiesFactoryBean propertiesFactoryBean = new YamlPropertiesFactoryBean();
        
        Resource resource = new ClassPathResource("config/application-" + getSpringProfilesActive() + ".yml");
        propertiesFactoryBean.setResources(resource);
        Properties properties = propertiesFactoryBean.getObject();
        
        return properties.getProperty(key);
        
    }
    
    
}
