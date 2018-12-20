package com.lzx.spring.aop.jdbc;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcUtil {

    private static String driver = "org.mariadb.jdbc.Driver";
    private static String url = "jdbc:mariadb://localhost:3306/testdb";
    private static String user = "root";
    private static String password = "123456";

    // 确保Connection不被其他线程滥用
    public static ThreadLocal<Connection> threadLocal = new ThreadLocal<Connection>();

    static {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            System.out.println("驱动加载失败");
        }
    }

    public static void getConnection() throws SQLException {
        System.out.println("打开数据库连接");
        threadLocal.set(DriverManager.getConnection(url, user, password));
    }

    public static <T> List<T> executeQuery(String sql, Class<T> clazz,Object... objects) throws SQLException, IllegalAccessException, InstantiationException, NoSuchFieldException {
        List<T> list = new ArrayList<>();
        PreparedStatement statement = threadLocal.get().prepareStatement(sql);
        if (objects != null) {
            for (int i = 0; i < objects.length; i++) {
                statement.setObject((i + 1), objects[i]);
            }
        }
        ResultSet resultSet = statement.executeQuery();
        ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
        while (resultSet.next()){
            T obj = clazz.newInstance();
            for (int i = 1; i <= resultSetMetaData.getColumnCount() ; i++) {
                String columnName = resultSetMetaData.getColumnName(i);
                Field field = clazz.getDeclaredField(columnName);
                field.setAccessible(true);
                field.set(obj, resultSet.getObject(i));
            }
            list.add(obj);
        }
        JdbcUtil.close(resultSet, statement, null);
        return list;
    }

    public static int executeUpdate(String sql, Object... objects) throws SQLException {
        PreparedStatement statement = threadLocal.get().prepareStatement(sql);
        if (objects != null) {
            for (int i = 0; i < objects.length; i++) {
                statement.setObject((i + 1), objects[i]);
            }
        }
        JdbcUtil.close(null, statement, null);
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
