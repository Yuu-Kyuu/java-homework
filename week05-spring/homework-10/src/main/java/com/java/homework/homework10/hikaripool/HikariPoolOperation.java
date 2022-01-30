package com.java.homework.homework10.hikaripool;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.sql.DataSource;

@Component
public class HikariPoolOperation {

    final DataSource dataSource;
    final JdbcTemplate jdbcTemplate;

    @Autowired
    public HikariPoolOperation(DataSource dataSource, JdbcTemplate jdbcTemplate) {
        this.dataSource = dataSource;
        this.jdbcTemplate = jdbcTemplate;
        System.out.println(dataSource.getClass());
    }


    public void poolInsert() {
        jdbcTemplate.execute("INSERT INTO test set test_name = '" + RandomStringUtils.randomAlphabetic(6) + "'");
    }

    public void poolDelete(int testId) {
        jdbcTemplate.execute("DELETE FROM test where test_id = " + testId);
    }

    public boolean poolUpdate(int testId, String testName) {
        String sql = "UPDATE test set test_name = ? where test_id = ? ";
        return jdbcTemplate.update(sql, testName, testId) == 1;
    }

    public String poolSelect() {
        return jdbcTemplate.queryForList("SELECT test_id, test_name FROM test").toString();
    }

}
