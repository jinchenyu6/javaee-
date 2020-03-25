package org.example.javaee.class01.JDBC;

import java.sql.*;

public class TestJdbc2 {

    public static String getMysql(){
        String url = "jdbc:mysql://127.0.0.1:3306/TestJdbc?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC";

        String driverName = "com.mysql.cj.jdbc.Driver";

        String  sqlString = "select * from test1";

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

            try {
                //加载驱动
                Class.forName(driverName);
                //创建连接
                connection = DriverManager.getConnection(url,"root","990619");
                //通过连接获取Statement
                statement = connection.createStatement();
                //Statement可以做一些增删改查
                resultSet = statement.executeQuery(sqlString);
                //获取执行结果
                while(resultSet.next()){
                    System.out.println(resultSet.getLong(2));
                }


            }catch (ClassNotFoundException e){
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                if(null != resultSet) {
                    try {
                        resultSet.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
                if(null != statement) {
                    try {
                        statement.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
                if(null != connection) {
                    try {
                        connection.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }



        return null;
    }
    public static void main(String[] args) {
        getMysql();
    }
}
