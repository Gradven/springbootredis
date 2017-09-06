package com.gradven.springboot.redis.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

/**
 * Created by liuhangjun on 2017/8/13.
 */
@Configuration
@EnableAsync
public class ExecutorConfig {
    
    /** Set the ThreadPoolExecutor's core pool size. */
    private int corePoolSize = 3;
    /** Set the ThreadPoolExecutor's maximum pool size. */
    private int maxPoolSize = 3;
    /** Set the capacity for the ThreadPoolExecutor's BlockingQueue. */
    private int queueCapacity = 1000;
    
    
    @Bean
    public Executor defaultAsyncExecutor() {
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        taskExecutor.setCorePoolSize(corePoolSize);
        taskExecutor.setMaxPoolSize(maxPoolSize);
        taskExecutor.setQueueCapacity(queueCapacity);
        taskExecutor.setThreadNamePrefix("default-");
        taskExecutor.initialize();
        return taskExecutor;
    }
    
}
