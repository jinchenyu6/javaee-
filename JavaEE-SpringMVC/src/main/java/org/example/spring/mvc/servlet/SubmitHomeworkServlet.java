package org.example.spring.mvc.servlet;

import org.example.spring.mvc.jdbc.StudentHomeworkJdbc;
import org.example.spring.mvc.model.StudentHomework;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/submitHomework")
public class SubmitHomeworkServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = Long.parseLong(req.getParameter("id"));
        Long studentId = Long.parseLong(req.getParameter("studentId"));
        Long homeworkId = Long.parseLong(req.getParameter("homeworkId"));
        String homeworkTitle = req.getParameter("homeworkTitle");
        String homeworkContent = req.getParameter("homeworkContent");

        StudentHomeworkJdbc submitHw = new StudentHomeworkJdbc();
            if(submitHw.isExistStudent(studentId)) {
                if(submitHw.isExistHomework(homeworkId)) {
                    StudentHomework sh = new StudentHomework();
                    sh.setId(id);
                    sh.setStudentId(studentId);
                    sh.setHomeworkId(homeworkId);
                    sh.setHomeworkTitle(new String(homeworkTitle.getBytes("ISO-8859-1"), "UTF-8"));
                    sh.setHomeworkContent(new String(homeworkContent.getBytes("ISO-8859-1"), "UTF-8"));
                    submitHw.submitHomework(sh);
                }
            }
        }
    }

