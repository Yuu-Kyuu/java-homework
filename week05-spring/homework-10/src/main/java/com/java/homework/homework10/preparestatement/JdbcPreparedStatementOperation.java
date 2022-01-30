package com.java.homework.homework10.preparestatement;

import com.java.homework.homework10.conf.DatabaseConf;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Component;

import java.sql.*;

/**
 * @author qiuch
 */
@Component
public class JdbcPreparedStatementOperation {
    final DatabaseConf conf;

    private Connection connection;

    public JdbcPreparedStatementOperation(DatabaseConf conf) {
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
            String sql = "INSERT INTO test(test_name) values (?)";
            PreparedStatement ptmt = connection.prepareStatement(sql);
            ptmt.setString(1, RandomStringUtils.randomAlphabetic(6));
            return ptmt.execute();
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
            String sql = "UPDATE test set test_name = ? where test_id = ? ";
            PreparedStatement ptmt = connection.prepareStatement(sql);
            ptmt.setString(1, testName);
            ptmt.setInt(2, testId);
            return ptmt.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public String jdbcSelectById(int testId) {
        StringBuilder result = new StringBuilder();
        try {
            String sql = "SELECT test_id,test_name FROM test WHERE test_id = ?";
            PreparedStatement ptmt = connection.prepareStatement(sql);
            ptmt.setInt(1, testId);
            ResultSet rs = ptmt.executeQuery();
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
