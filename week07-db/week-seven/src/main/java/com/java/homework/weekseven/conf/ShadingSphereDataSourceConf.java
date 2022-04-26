package com.java.homework.weekseven.conf;

import com.zaxxer.hikari.HikariDataSource;
import org.apache.shardingsphere.driver.api.ShardingSphereDataSourceFactory;
import org.apache.shardingsphere.infra.config.algorithm.ShardingSphereAlgorithmConfiguration;
import org.apache.shardingsphere.readwritesplitting.api.ReadwriteSplittingRuleConfiguration;
import org.apache.shardingsphere.readwritesplitting.api.rule.ReadwriteSplittingDataSourceRuleConfiguration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.*;

@Configuration
public class ShadingSphereDataSourceConf {

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

    @Primary
    @Bean("shardingSphereDataSource")
    public DataSource shardingSphereDataSource() {
        Map<String, DataSource> datasourceMaps = new HashMap<>(2);
        datasourceMaps.put("readDataSource", readWriteDataSource());
        datasourceMaps.put("writeDataSource", commonDataSource());
        /* 分片规则配置 */
// 表达式 ds_${0..1} 枚举值表示的是主从配置的逻辑数据源名称列表
//        ShardingTableRuleConfiguration tOrderRuleConfiguration = new ShardingTableRuleConfiguration("t_order", "ds_${0..1}.t_order_${[0, 1]}");
//        tOrderRuleConfiguration.setKeyGenerateStrategy(new KeyGenerateStrategyConfiguration("order_id", "snowflake"));
//        tOrderRuleConfiguration.setTableShardingStrategy(new StandardShardingStrategyConfiguration("order_id", "tOrderInlineShardingAlgorithm"));
//        Properties tOrderShardingInlineProps = new Properties();
//        tOrderShardingInlineProps.setProperty("algorithm-expression", "t_order_${order_id % 2}");
//        tOrderRuleConfiguration.getShardingAlgorithms().putIfAbsent("tOrderInlineShardingAlgorithm", new ShardingSphereAlgorithmConfiguration("INLINE", tOrderShardingInlineProps));
//
//        ShardingTableRuleConfiguration tOrderItemRuleConfiguration = new ShardingTableRuleConfiguration("t_order_item", "ds_${0..1}.t_order_item_${[0, 1]}");
//        tOrderItemRuleConfiguration.setKeyGenerateStrategy(new KeyGenerateStrategyConfiguration("order_item_id", "snowflake"));
//        tOrderRuleConfiguration.setTableShardingStrategy(new StandardShardingStrategyConfiguration("order_item_id", "tOrderItemInlineShardingAlgorithm"));
//        Properties tOrderItemShardingInlineProps = new Properties();
//        tOrderItemShardingInlineProps.setProperty("algorithm-expression", "t_order_item_${order_item_id % 2}");
//        tOrderRuleConfiguration.getShardingAlgorithms().putIfAbsent("tOrderItemInlineShardingAlgorithm", new ShardingSphereAlgorithmConfiguration("INLINE", tOrderItemShardingInlineProps));
//
//        ShardingRuleConfiguration shardingRuleConfiguration = new ShardingRuleConfiguration();
//        shardingRuleConfiguration.getTables().add(tOrderRuleConfiguration);
//        shardingRuleConfiguration.getTables().add(tOrderItemRuleConfiguration);
//        shardingRuleConfiguration.getBindingTableGroups().add("t_order, t_order_item");
//        shardingRuleConfiguration.getBroadcastTables().add("t_bank");
//// 默认分库策略
//        shardingRuleConfiguration.setDefaultDatabaseShardingStrategy(new StandardShardingStrategyConfiguration("user_id", "default_db_strategy_inline"));
//        Properties defaultDatabaseStrategyInlineProps = new Properties();
//        defaultDatabaseStrategyInlineProps.setProperty("algorithm-expression", "ds_${user_id % 2}");
//        shardingRuleConfiguration.getShardingAlgorithms().put("default_db_strategy_inline", new ShardingSphereAlgorithmConfiguration("INLINE", defaultDatabaseStrategyInlineProps));
//// 分布式序列算法配置
//        Properties snowflakeProperties = new Properties();
//        shardingRuleConfiguration.getKeyGenerators().put("snowflake", new ShardingSphereAlgorithmConfiguration("SNOWFLAKE", snowflakeProperties));
//
//        /* 数据加密规则配置 */
//        Properties encryptProperties = new Properties();
//        encryptProperties.setProperty("aes-key-value", "123456");
//        EncryptColumnRuleConfiguration columnConfigAes = new EncryptColumnRuleConfiguration("username", "username", "", "username_plain", "name_encryptor");
//        EncryptColumnRuleConfiguration columnConfigTest = new EncryptColumnRuleConfiguration("pwd", "pwd", "assisted_query_pwd", "", "pwd_encryptor");
//        EncryptTableRuleConfiguration encryptTableRuleConfig = new EncryptTableRuleConfiguration("t_user", Arrays.asList(columnConfigAes, columnConfigTest));
//
//        Map<String, ShardingSphereAlgorithmConfiguration> encryptAlgorithmConfigs = new LinkedHashMap<>(2, 1);
//        encryptAlgorithmConfigs.put("name_encryptor", new ShardingSphereAlgorithmConfiguration("AES", encryptProperties));
//        encryptAlgorithmConfigs.put("pwd_encryptor", new ShardingSphereAlgorithmConfiguration("assistedTest", encryptProperties));
//        EncryptRuleConfiguration encryptRuleConfiguration = new EncryptRuleConfiguration(Collections.singleton(encryptTableRuleConfig), encryptAlgorithmConfigs);

        /* 读写分离规则配置 */
        Properties readwriteProps1 = new Properties();
        readwriteProps1.setProperty("write-data-source-name", "writeDataSource");
        readwriteProps1.setProperty("read-data-source-names", "readDataSource");
        ReadwriteSplittingDataSourceRuleConfiguration dataSourceConfiguration1 = new ReadwriteSplittingDataSourceRuleConfiguration("ds", "static", readwriteProps1, null);

//        Properties readwriteProps2 = new Properties();
//        readwriteProps2.setProperty("write-data-source-name", "write_ds0");
//        readwriteProps2.setProperty("read-data-source-names", "write_ds1_read0, write_ds1_read1");
//        ReadwriteSplittingDataSourceRuleConfiguration dataSourceConfiguration2 = new ReadwriteSplittingDataSourceRuleConfiguration("ds_1", "Static", readwriteProps2, "roundRobin");

// 负载均衡算法
        Map<String, ShardingSphereAlgorithmConfiguration> loadBalanceMaps = new HashMap<>(1);
        loadBalanceMaps.put("roundRobin", new ShardingSphereAlgorithmConfiguration("ROUND_ROBIN", new Properties()));

        //new ReadwriteSplittingRuleConfiguration(Arrays.asList(dataSourceConfiguration1, dataSourceConfiguration2), loadBalanceMaps);
        ReadwriteSplittingRuleConfiguration readWriteSplittingyRuleConfiguration = new ReadwriteSplittingRuleConfiguration(
                Collections.singletonList(dataSourceConfiguration1), loadBalanceMaps);

        /* 其他配置 */
        Properties otherProperties = new Properties();
        otherProperties.setProperty("sql-show", "true");

        /* shardingDataSource 就是最终被 ORM 框架或其他 jdbc 框架引用的数据源名称 */
//        Arrays.asList(shardingRuleConfiguration, readWriteSplittingyRuleConfiguration, encryptRuleConfiguration)
        DataSource shardingDataSource = null;
        try {
            shardingDataSource = ShardingSphereDataSourceFactory.createDataSource(datasourceMaps, Collections.singletonList(readWriteSplittingyRuleConfiguration), otherProperties);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return shardingDataSource;
    }
}
