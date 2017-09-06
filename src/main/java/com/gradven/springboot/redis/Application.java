/**
 *
 */
package com.gradven.springboot.redis;

import com.gradven.springboot.redis.yaml.spring.SpringYaml;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;


/**
 * @author liuhangjun
 * @date 2017年1月28日
 *
 */
@MapperScan("com.gradven.springboot.redis.mapper")
@ServletComponentScan
@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    private SpringYaml springYaml;

    @Override
    public void run(String... args) {
        System.out.println();
        System.out.println("=============================================");
        System.out.println("Current project name : " + this.springYaml.getApplication().getName());
        System.out.println("=============================================");
        System.out.println();
    }


    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);

    }

}
