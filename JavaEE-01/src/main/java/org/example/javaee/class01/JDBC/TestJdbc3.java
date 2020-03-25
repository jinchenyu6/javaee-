package org.example.javaee.class01.JDBC;

import java.sql.*;

public class TestJdbc3 {

    public static String getMysql(){
        String url = "jdbc:mysql://127.0.0.1:3306/TestJdbc?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC";

        String driverName = "com.mysql.cj.jdbc.Driver";

        String  sqlString = "select * from test1";
        try {
            //加载驱动
            Class.forName(driverName);

        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

            try(Connection connection = DriverManager.getConnection(url,"root","990619")){
                try(Statement statement = connection.createStatement()){
                    try(ResultSet resultSet = statement.executeQuery(sqlString)){
                        while(resultSet.next()){
                            System.out.println(resultSet.getLong(2));
                        }

                    }
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }




            return null;
    }
    public static void main(String[] args) {
        getMysql();
    }
}
