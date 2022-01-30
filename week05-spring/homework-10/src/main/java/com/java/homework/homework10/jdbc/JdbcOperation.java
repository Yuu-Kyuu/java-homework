package com.java.homework.homework10.jdbc;

import com.java.homework.homework10.conf.DatabaseConf;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.*;

/**
 * @author qiuch
 */
@Component
public class JdbcOperation {
    final DatabaseConf conf;

    private Connection connection;

    public JdbcOperation(DatabaseConf conf) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                    conf.getDbUrl(),
                    conf.getDbUser(),
                    conf.getDbPass());
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        this.conf = conf;
    }

    public boolean jdbcInsert() {
        try {
            Statement stmt = connection.createStatement();
            return stmt.execute("INSERT INTO test set test_name = '" + RandomStringUtils.randomAlphabetic(6) + "'");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean jdbcDelete(int testId) {
        try {
            Statement stmt = connection.createStatement();
            return stmt.execute("DELETE FROM test where test_id = " + testId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean jdbcUpdate(int testId, String testName) {
        try {
            Statement stmt = connection.createStatement();
            return stmt.execute("UPDATE test set test_name = '" + testName + "' where test_id = " + testId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public String jdbcSelect() {
        StringBuilder result = new StringBuilder();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT test_id, test_name FROM test");
            while (rs.next()) {
                result.append("[")
                        .append(rs.getInt("test_id"))
                        .append(":")
                        .append(rs.getString("test_name"))
                        .append(" ]");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result.toString();
    }
}
