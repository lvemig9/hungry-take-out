package com.hungry;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * @Author:ascrm
 * @Date:2024/4/26
 */
@SpringBootApplication
@Slf4j
public class HungryTakeOutApplication {
    public static void main(String[] args) {
        SpringApplication.run(HungryTakeOutApplication.class, args);
        log.info("项目启动成功...");
    }
}