<%@ page import="java.util.List" %>
<%@ page import="org.example.spring.mvc.model.Homework" %>
<%@ page import="org.example.spring.mvc.bean.bean1" %>
<%@ page import="org.example.spring.mvc.model.Student" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %><%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2020/3/10
  Time: 22:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Student</title>
</head>
<body>
<h1 align="center">已留作业</h1>
<table align="center" width="800" border="1"  cellpadding="1" cellspacing="1">
    <tr align="center" height="50" bgcolor="#faebd7">
        <td>作业编号</td>
        <td>作业标题</td>
        <td>作业内容</td>
        <td>创建时间</td>
    </tr>
    <%
        List<Homework> list = (List<Homework>) bean1.selectAllHomework();
        if(null == list || list.size()<=0){
            out.println("No data.");
        }else{
            for (Homework hw : list){
    %>
    <tr align="center">
        <td><%=hw.getId()%></td>
        <td><%=hw.getTitle()%></td>
        <td><%=hw.getContent()%></td>
        <td><%=hw.getCreate_time()%></td>
    </tr>
    <%
            }
        }%>
</table>
<h1 align="center">学生名单</h1>
<table align="center" width="800" border="1"  cellpadding="1" cellspacing="1">
    <tr align="center" height="50" bgcolor="#faebd7">
        <td>学生学号</td>
        <td>学生名字</td>
        <td>添加时间</td>
    </tr>
    <%
        List<Student> list2 = (List<Student>) bean1.selectAllStudent();
        if(null == list || list.size()<=0){
            out.println("No data.");
        }else{
            for (Student stu : list2){
    %>
    <tr align="center">
        <td><%=stu.getId()%></td>
        <td><%=stu.getName()%></td>
        <td><%=stu.getCreate_time()%></td>
    </tr>
    <%
            }
        }%>
</table>
<h1 align="center">提交作业</h1>
<form action="submitHomework" method="post">
    <table align="center" width="800" border="1"  cellpadding="1" cellspacing="1">
        <tr align="center" height="50" bgcolor="#faebd7">
            <td>作业序号</td>
            <td><input type="text" name="id"></td>
        </tr>
        <tr align="center" height="50" bgcolor="#faebd7">
            <td>学生学号</td>
            <td><input type="text" name="studentId"></td>
        </tr>
        <tr align="center" height="50" bgcolor="#faebd7">
            <td>作业编号</td>
            <td><input type="text" name="homeworkId"></td>
        </tr>
        <tr align="center" height="50" bgcolor="#faebd7">
            <td>作业标题</td>
            <td><input type="text" name="homeworkTitle"></td>
        </tr>
        <tr align="center" height="50" bgcolor="#faebd7">
            <td>作业内容</td>
            <td><input type="text" name="homeworkContent"></td>
        </tr>
        <tr align="center" height="50" bgcolor="#faebd7">
            <td>操作</td>
            <td><input type="submit" value="提交"><input type="reset" value="重置"></td>
        </tr>
    </table>
</form>
</body>
</html>
