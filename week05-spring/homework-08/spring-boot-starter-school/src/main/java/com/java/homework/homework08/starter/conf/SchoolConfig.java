package com.java.homework.homework08.starter.conf;

import com.java.homework.homework08.starter.service.School;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * school自动装配配置类
 * @author qiuch
 */
@Configuration
public class SchoolConfig {
    @Bean
    public School school() {
        return new School();
    }
}
