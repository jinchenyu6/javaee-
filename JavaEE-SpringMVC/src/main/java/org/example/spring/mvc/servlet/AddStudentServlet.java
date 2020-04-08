package org.example.spring.mvc.servlet;

import org.example.spring.mvc.jdbc.StudentHomeworkJdbc;
import org.example.spring.mvc.model.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addStu")
public class AddStudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        this.doPost(req, resp);
    }
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = Long.parseLong(req.getParameter("id"));
        String name = req.getParameter("name");


        Student stu = new Student();
        stu.setId(id);
        stu.setName(new String(name.getBytes("ISO-8859-1"), "UTF-8"));
        StudentHomeworkJdbc addStu = new StudentHomeworkJdbc();
        addStu.addStudent(stu);

    }

}
