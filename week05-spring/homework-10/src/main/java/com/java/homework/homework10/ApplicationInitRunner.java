package com.java.homework.homework10;

import com.java.homework.homework10.hikaripool.HikariPoolOperation;
import com.java.homework.homework10.jdbc.JdbcOperation;
import com.java.homework.homework10.preparestatement.JdbcPreparedStatementOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class ApplicationInitRunner implements ApplicationRunner {

    @Autowired
    JdbcOperation jdbc;

    @Autowired
    JdbcPreparedStatementOperation preparedStatementOperation;

    @Autowired
    HikariPoolOperation hikariPoolOperation;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        jdbc.jdbcInsert();
        System.out.println(jdbc.jdbcSelect());
        jdbc.jdbcUpdate(1, "java homework");
//        jdbc.jdbcDelete(1);


        preparedStatementOperation.jdbcInsert();
        System.out.println(preparedStatementOperation.jdbcSelectById(3));
        preparedStatementOperation.jdbcUpdate(3, "java-homework-03");
//        preparedStatementOperation.jdbcDelete(3);

        hikariPoolOperation.poolInsert();
        System.out.println(hikariPoolOperation.poolSelect());
        hikariPoolOperation.poolUpdate(4, "javahomework-04");
//        hikariPoolOperation.poolDelete(4);
    }
}
