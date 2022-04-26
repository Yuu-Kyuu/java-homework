package com.java.homework.weekseven.conf;


import com.java.homework.weekseven.component.ReadWriteDataSource;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.shardingsphere.driver.api.ShardingSphereDataSourceFactory;
import org.apache.shardingsphere.infra.config.algorithm.ShardingSphereAlgorithmConfiguration;
import org.apache.shardingsphere.readwritesplitting.api.ReadwriteSplittingRuleConfiguration;
import org.apache.shardingsphere.readwritesplitting.api.rule.ReadwriteSplittingDataSourceRuleConfiguration;
import org.apache.shardingsphere.sharding.api.config.ShardingRuleConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.metamodel.Metamodel;
import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.*;

/**
 * @author qiucihang
 */
//@Configuration
//@EnableJpaRepositories(basePackages = "com.java.homework.weekseven",
//        entityManagerFactoryRef = "localEntityManager",
//        transactionManagerRef = "localTransactionManager")
//@EnableTransactionManagement
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

    //    @Primary
    @Bean("writeDataSource")
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

    @Bean("readDataSource")
    public DataSource readWriteDataSource() {
        HikariDataSource hikariDataSource = new HikariDataSource();
        hikariDataSource.setDriverClassName(dbDriver);
        hikariDataSource.setJdbcUrl(dbReadUrl);
        hikariDataSource.setUsername(dbReadUser);
        hikariDataSource.setPassword(dbReadPass);
        return hikariDataSource;
    }


    //    @Primary
    @Bean
    public ReadWriteDataSource dataSource(DataSource readDataSource, DataSource writeDataSource) {
        Map<Object, Object> targetDataSources = new HashMap<>(2);
        targetDataSources.put(ReadWriteDataSource.READ_DATASOURCE, readDataSource);
        targetDataSources.put(ReadWriteDataSource.WRITE_DATASOURCE, writeDataSource);
        return new ReadWriteDataSource(readDataSource, targetDataSources);
    }

    @Bean(name = "localEntityManager")
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(EntityManagerFactoryBuilder builder) {
        return builder.dataSource(dataSource(readWriteDataSource(), commonDataSource())).packages("com.java.homework.weekseven.data.entity").build();
    }

    @Bean(name = "localTransactionManager")
    public JpaTransactionManager transactionManager(
            @Autowired @Qualifier("localEntityManager") LocalContainerEntityManagerFactoryBean entityManagerFactoryBean) {
        return new JpaTransactionManager(entityManagerFactoryBean.getObject());
    }


}
