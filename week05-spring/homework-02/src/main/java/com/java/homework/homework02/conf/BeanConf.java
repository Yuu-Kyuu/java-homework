package com.java.homework.homework02.conf;

import com.java.homework.homework02.entity.ConfBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConf {

    @Bean
    public ConfBean confBean() {
        return new ConfBean();
    }
}
