package org.example.javaee.class01.JDBC;

import org.example.javaee.class01.model.Homework;
import org.example.javaee.class01.model.StudentHomework;
import org.example.javaee.class01.model.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentHomeworkJdbc {

    public static List<StudentHomework> selectAll(){
       // String url = "jdbc:mysql://127.0.0.1:3306/school?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC";
        //String driverName = "com.mysql.cj.jdbc.Driver";


        String  sqlString = "select * from s_student_homework";
      /*  try {
            //加载驱动
            Class.forName(driverName);

        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        }*/

        List<StudentHomework> list = new ArrayList<>();

        try(Connection connection = DatabasePool.getHikariDataSource().getConnection()){
            try(Statement statement = connection.createStatement()){
                try(ResultSet resultSet = statement.executeQuery(sqlString)){
                    while(resultSet.next()){
                        StudentHomework sh = new StudentHomework();
                        sh.setId(resultSet.getLong("id"));
                        sh.setStudentId(resultSet.getLong("student_id"));
                        sh.setHomeworkId(resultSet.getLong("homework_id"));
                        sh.setHomeworkTitle(resultSet.getString("homework_title"));
                        sh.setHomeworkContent(resultSet.getString("homework_content"));
                        sh.setCreateTime(resultSet.getTimestamp("create_time"));
                        list.add(sh);
                    }

                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return list;
    }
    public static List<Student> selectAllStudent(){


        String  sqlString = "select * from s_student";

        List<Student> list = new ArrayList<>();

        try(Connection connection = DatabasePool.getHikariDataSource().getConnection()){
            try(Statement statement = connection.createStatement()){
                try(ResultSet resultSet = statement.executeQuery(sqlString)){
                    while(resultSet.next()){
                        Student stu = new Student();
                        stu.setId(resultSet.getLong("id"));
                        stu.setName(resultSet.getString("name"));
                        stu.setCreate_time(resultSet.getTimestamp("create_time"));
                        list.add(stu);
                    }

                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return list;
    }
    public static List<Homework> selectAllHomework(){


        String  sqlString = "select * from s_homework";


        List<Homework> list = new ArrayList<>();

        try(Connection connection = DatabasePool.getHikariDataSource().getConnection()){
            try(Statement statement = connection.createStatement()){
                try(ResultSet resultSet = statement.executeQuery(sqlString)){
                    while(resultSet.next()){
                        Homework hw = new Homework();
                        hw.setId(resultSet.getLong("id"));
                        hw.setTitle(resultSet.getString("title"));
                        hw.setContent(resultSet.getString("content"));
                        hw.setCreate_time(resultSet.getTimestamp("create_time"));
                        list.add(hw);
                    }

                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return list;
    }
    public boolean addHomework(Homework hw) {

        String sql = "INSERT INTO `school`.`s_homework`(`id`,`title`,`content`,`create_time`,`update_time`) VALUES (?,?,?,?,?)";


        try(Connection connection = DatabasePool.getHikariDataSource().getConnection()){
            PreparedStatement ps =  connection.prepareStatement(sql);
            ps.setLong(1,hw.getId());
            ps.setString(2,hw.getTitle());
            ps.setString(3,hw.getContent());
            ps.setTimestamp(4, (Timestamp) hw.getCreate_time());
            ps.setTimestamp(5, (Timestamp) hw.getUpdate_time());
            int count = ps.executeUpdate();
            ps.close();
            return count > 0 ? true : false;
        }catch(SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    public boolean addStudent(Student stu) {

        String sql = "INSERT INTO `school`.`s_student`(`id`,`name`,`create_time`,`update_time`) VALUES (?,?,?,?)";


        try(Connection connection = DatabasePool.getHikariDataSource().getConnection()){
            PreparedStatement ps =  connection.prepareStatement(sql);
            ps.setLong(1,stu.getId());
            ps.setString(2,stu.getName());
            ps.setTimestamp(3, (Timestamp) stu.getCreate_time());
            ps.setTimestamp(4, (Timestamp) stu.getUpdate_time());
            int count = ps.executeUpdate();
            ps.close();
            return count > 0 ? true : false;
        }catch(SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    public boolean submitHomework(StudentHomework studentHomework) {

        String sql = "INSERT INTO `school`.`s_student_homework`(`id`,`student_id`,`homework_id`,`homework_title`,`homework_content`,`create_time`,`update_time`) VALUES (?,?,?,?,?,?,?)";


        try(Connection connection = DatabasePool.getHikariDataSource().getConnection()){
            PreparedStatement ps =  connection.prepareStatement(sql);
            ps.setLong(1,studentHomework.getId());
            ps.setLong(2,studentHomework.getStudentId());
            ps.setLong(3,studentHomework.getHomeworkId());
            ps.setString(4,studentHomework.getHomeworkTitle());
            ps.setString(5,studentHomework.getHomeworkContent());
            ps.setTimestamp(6, (Timestamp) studentHomework.getCreateTime());
            ps.setTimestamp(7, (Timestamp) studentHomework.getUpdateTime());
            int count = ps.executeUpdate();
            ps.close();
            return count > 0 ? true : false;
        }catch(SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    public boolean isExistStudent(Long id){


        String sql = "SELECT * from `school`.`s_student` where id = ? ";
        boolean flag = false;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = DatabasePool.getHikariDataSource().getConnection();
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setLong(1,id);
            resultSet = preparedStatement.executeQuery();
            //获取执行结果
            if(resultSet.next()){
                flag = true;
            }
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
            if(null != preparedStatement) {
                try {
                    preparedStatement.close();
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
        return flag;
    }

    public boolean isExistHomework(Long id){

        String sql = "SELECT * from `school`.`s_homework` where id = ? ";
        boolean flag = false;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {

            connection = DatabasePool.getHikariDataSource().getConnection();
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setLong(1,id);
            resultSet = preparedStatement.executeQuery();
            //获取执行结果
            if(resultSet.next()){
                flag = true;
            }
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
            if(null != preparedStatement) {
                try {
                    preparedStatement.close();
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
        return flag;
    }


    public static void main(String[] args) {
        List<StudentHomework> list = selectAll();
        for(StudentHomework sh : list){
            System.out.println(sh.getHomeworkContent());
        }
    }
}
