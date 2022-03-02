package com.java.homework.weekseven.conf;


import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * @author qiucihang
 */
@Configuration
public class DataSourceConf {
    @Value("${spring.datasource.write.url}")
    private String dbWriteUrl;
    @Value("${spring.datasource.write.username}")
    private String dbWriteUser;
    @Value("${spring.datasource.write.password}")
    private String dbWritePass;

    @Value("${spring.datasource.read.url}")
    private String dbReadUrl;
    @Value("${spring.datasource.read.username}")
    private String dbReadUser;
    @Value("${spring.datasource.read.password}")
    private String dbReadPass;

    @Value("${spring.datasource.driver-class-name}")
    private String dbDriver;

    @Primary
    @Bean("dataSource")
    public DataSource commonDataSource() {
        HikariDataSource hikariDataSource = new HikariDataSource();
        hikariDataSource.setDriverClassName(dbDriver);
        hikariDataSource.setJdbcUrl(dbWriteUrl);
        hikariDataSource.setUsername(dbWriteUser);
        hikariDataSource.setPassword(dbWritePass);
//        hikariDataSource.setConnectionTimeout(Long.parseLong(env.getProperty("spring.datasource.connectionTimeout")));
//        hikariDataSource.setIdleTimeout(Long.parseLong(env.getProperty("spring.datasource.idleTimeout")));
//        hikariDataSource.setValidationTimeout(Long.parseLong(env.getProperty("spring.datasource.validationTimeout")));
//        hikariDataSource.setLoginTimeout(Integer.parseInt(env.getProperty("spring.datasource.loginTimeout")));
//        hikariDataSource.setMaxLifetime(Long.parseLong(env.getProperty("spring.datasource.maxLifetime")));
//        hikariDataSource.setMaximumPoolSize(Integer.parseInt(env.getProperty("spring.datasource.maximumPoolSize")));
        return hikariDataSource;
    }

    @Bean("readWriteDataSource")
    public DataSource readWriteDataSource() {
        HikariDataSource hikariDataSource = new HikariDataSource();
        hikariDataSource.setDriverClassName(dbDriver);
        hikariDataSource.setJdbcUrl(dbReadUrl);
        hikariDataSource.setUsername(dbReadUser);
        hikariDataSource.setPassword(dbReadPass);

        return hikariDataSource;
//        return new ReadWriteDataSource();
    }

//    @Bean("shardingSphereDataSource")
//    public DataSource shardingSphereDataSource() {
//        DataSource dataSource = ShardingSphereDataSourceFactory.createDataSource(schemaName, modeConfig, dataSourceMap, ruleConfigs, props);
//        return dataSource;
//    }
}
