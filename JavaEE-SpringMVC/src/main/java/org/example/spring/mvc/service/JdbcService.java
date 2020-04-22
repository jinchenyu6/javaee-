package org.example.spring.mvc.service;


import org.example.spring.mvc.bean.Homework;
import org.example.spring.mvc.bean.Student;
import org.example.spring.mvc.bean.StudentHomework;
import org.example.spring.mvc.jdbc.StudentHomeworkJdbc;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author DELL
 */
@Service

public class JdbcService {


/*    public void getById(Long id){
        System.out.println("getById("+ id + ")");
    }*/
    public JdbcService getJdbcService(){
        return new JdbcService();
    }

    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(StudentHomeworkJdbc.class);
    StudentHomeworkJdbc studentHomeworkJdbc = (StudentHomeworkJdbc)context.getBean("studentHomeworkJdbc");

    public  List<StudentHomework> selectAll(){
        return StudentHomeworkJdbc.selectAll();
    }

    public  List<Student> selectAllStudent(){
        return StudentHomeworkJdbc.selectAllStudent();
    }
    public  List<Homework> selectAllHomework(){
        return StudentHomeworkJdbc.selectAllHomework();
    }

    public boolean addHomework(Homework hw){
        return studentHomeworkJdbc.addHomework(hw);
    }

    public boolean addStudent(Student stu){
        return studentHomeworkJdbc.addStudent(stu);
    }

    public boolean submitHomework(StudentHomework studentHomework){
        return studentHomeworkJdbc.submitHomework(studentHomework);
    }

    public boolean isExistStudent(Long id){
        return studentHomeworkJdbc.isExistStudent(id);
    }

    public boolean isExistHomework(Long id){
        return studentHomeworkJdbc.isExistHomework(id);
    }
}
