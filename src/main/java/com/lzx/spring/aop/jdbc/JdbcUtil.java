package com.lzx.spring.aop.jdbc;

import java.sql.*;

public class JdbcUtil {

    private static String driver = "org.mariadb.jdbc.Driver";
    private static String url = "jdbc:mariadb://localhost:3306/testdb";
    private static String user = "root";
    private static String password = "123456";

    static {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            System.out.println("驱动加载失败");
        }
    }

    public static Connection getConnection() throws SQLException {
        System.out.println("打开数据库连接");
        return DriverManager.getConnection(url, user, password);
    }

    public static ResultSet executeQuery(String sql, Object... objects) throws SQLException {
        PreparedStatement statement = JdbcUtil.getConnection().prepareStatement(sql);
        if (objects != null) {
            for (int i = 0; i < objects.length; i++) {
                statement.setObject((i + 1), objects[i]);
            }
        }
        return statement.executeQuery();
    }

    public static int executeUpdate(String sql, Object... objects) throws SQLException {
        PreparedStatement statement = JdbcUtil.getConnection().prepareStatement(sql);
        if (objects != null) {
            for (int i = 0; i < objects.length; i++) {
                statement.setObject((i + 1), objects[i]);
            }
        }
        return statement.executeUpdate();
    }

    public static void close(ResultSet resultSet, Statement statement, Connection connection) throws SQLException {
        if (resultSet != null && !resultSet.isClosed()) {
            resultSet.close();
        }
        if (statement != null && !statement.isClosed()) {
            statement.close();
        }
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
        System.out.println("关闭数据库连接");
    }

    public static void rollBack(Connection connection) {
        try {
            connection.rollback();
        } catch (Exception e) {
            System.out.println("数据回滚发生异常：" + e.getMessage());
        } finally {
            System.out.println("操作失败");
        }
    }
}
