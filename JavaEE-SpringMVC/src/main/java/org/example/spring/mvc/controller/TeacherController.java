package org.example.spring.mvc.controller;

import org.example.spring.mvc.bean.bean1;
import org.example.spring.mvc.model.Homework;
import org.example.spring.mvc.model.Student;
import org.example.spring.mvc.model.StudentHomework;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
/*@RequestMapping("/Teacher/")*/
public class TeacherController  extends HttpServlet {
    @RequestMapping("/add")
    public void AddStudentHomeworkServlet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = Long.parseLong(req.getParameter("id"));
        String title = req.getParameter("title");
        String content = req.getParameter("content");


        Homework hw = new Homework();
        hw.setId(id);
        hw.setTitle(new String(title.getBytes("ISO-8859-1"), "UTF-8"));
        hw.setContent(new String(content.getBytes("ISO-8859-1"), "UTF-8"));
        bean1 add = new bean1();
        add.addHomework(hw);
    }

    @RequestMapping("/addStu")
    public void AddStudentServlet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = Long.parseLong(req.getParameter("id"));
        String name = req.getParameter("name");


        Student stu = new Student();
        stu.setId(id);
        stu.setName(new String(name.getBytes("ISO-8859-1"), "UTF-8"));
        bean1 addStu = new bean1();
        addStu.addStudent(stu);
    }

    @RequestMapping("/list")
    public void StudentHomeworkServlet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<StudentHomework> list = bean1.selectAll();

        req.setAttribute("list",list);

        req.getRequestDispatcher("index.jsp").forward(req,resp);
    }
}
