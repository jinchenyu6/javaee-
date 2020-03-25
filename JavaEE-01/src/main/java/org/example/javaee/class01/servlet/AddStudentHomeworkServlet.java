package org.example.javaee.class01.servlet;

import org.example.javaee.class01.JDBC.StudentHomeworkJdbc;
import org.example.javaee.class01.model.Homework;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/add")
public class AddStudentHomeworkServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        this.doPost(req, resp);
    }
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = Long.parseLong(req.getParameter("id"));
        String title = req.getParameter("title");
        String content = req.getParameter("content");


        Homework hw = new Homework();
        hw.setId(id);
        hw.setTitle(new String(title.getBytes("ISO-8859-1"), "UTF-8"));
        hw.setContent(new String(content.getBytes("ISO-8859-1"), "UTF-8"));
        StudentHomeworkJdbc add = new StudentHomeworkJdbc();
        add.addHomework(hw);

    }

}
