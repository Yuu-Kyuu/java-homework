package com.java.homework.homework10.conf;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Data
@Component
public class DatabaseConf {
    @Value("${homework.datasource.url}")
    private String dbUrl;
    @Value("${homework.datasource.username}")
    private String dbUser;
    @Value("${homework.datasource.password}")
    private String dbPass;
}
