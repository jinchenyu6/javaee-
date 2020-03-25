package org.example.javaee.class01.JDBC;

import java.io.PrintWriter;
import java.sql.*;

public class TestJdbc {

    public static String getMysql(){
       String url = "jdbc:mysql://127.0.0.1:3306/TestJdbc?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC";

        String driverName = "com.mysql.cj.jdbc.Driver";

        String  sqlString = "select * from test1";

        //把DriverManger println 输出到控制台
        DriverManager.setLogWriter( new PrintWriter(System.out));

        try {
            //加载驱动
            Class.forName(driverName);
            //创建连接
            Connection connection = DriverManager.getConnection(url,"root","990619");
            //通过连接获取Statement
            Statement statement = connection.createStatement();
            //Statement可以做一些增删改查
            ResultSet resultSet = statement.executeQuery(sqlString);
            //获取执行结果
            while(resultSet.next()){
                System.out.println(resultSet.getLong(2));
            }



        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static void main(String[] args) {
        getMysql();
    }
}
