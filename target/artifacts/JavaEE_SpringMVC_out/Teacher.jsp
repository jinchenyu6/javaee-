<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2020/3/10
  Time: 22:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.List" %>
<%@ page import="org.example.spring.mvc.bean.Student" %>
<%@ page import="org.example.spring.mvc.jdbc.StudentHomeworkJdbc" %>
<%@ page import="org.example.spring.mvc.bean.StudentHomework" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Teacher</title>
</head>
<body>

<h1 align="center">添加学生</h1>
<form action="addStu" method="post">
    <table align="center" width="800" border="1"  cellpadding="1" cellspacing="1">
        <tr align="center" height="50" bgcolor="#faebd7">
            <td>学生学号</td>
            <td><input type="text" name="id"></td>
        </tr>
        <tr align="center" height="50" bgcolor="#faebd7">
            <td>学生名字</td>
            <td><input type="text" name="name"></td>
        </tr>
        <tr align="center" height="50" bgcolor="#faebd7">
            <td>操作</td>
            <td><input type="submit" value="提交"><input type="reset" value="重置"></td>
        </tr>
    </table>
</form>
<h1 align="center">已添加学生</h1>
<table align="center" width="800" border="1"  cellpadding="1" cellspacing="1">
    <tr align="center" height="50" bgcolor="#faebd7">
        <td>学生学号</td>
        <td>学生名字</td>
        <td>添加时间</td>
    </tr>
    <%
        List<Student> list = (List<Student>) StudentHomeworkJdbc.selectAllStudent();
        if(null == list || list.size()<=0){
            out.println("No data.");
        }else{
            for (Student stu : list){
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

<h1 align="center">布置作业</h1>
<form action="add" method="post">
    <table align="center" width="800" border="1"  cellpadding="1" cellspacing="1">
        <tr align="center" height="50" bgcolor="#faebd7">
            <td>作业序号</td>
            <td><input type="text" name="id"></td>
        </tr>
        <tr align="center" height="50" bgcolor="#faebd7">
            <td>作业名称</td>
            <td><input type="text" name="title"></td>
        </tr>
        <tr align="center" height="50" bgcolor="#faebd7">
            <td>作业内容</td>
            <td><input type="text" name="content"></td>
        </tr>
        <tr align="center" height="50" bgcolor="#faebd7">
            <td>操作</td>
            <td><input type="submit" value="提交"><input type="reset" value="重置"></td>
        </tr>
    </table>
</form>
<h1 align="center">检查作业</h1>
<table align="center" width="800" border="1"  cellpadding="1" cellspacing="1">
    <tr align="center" height="50" bgcolor="#faebd7">
        <td>ID</td>
        <td>学生学号</td>
        <td>作业编号</td>
        <td>作业标题</td>
        <td>作业内容</td>
        <td>创建时间</td>

    </tr>
    <%
        List<StudentHomework> list2 = (List<StudentHomework>) StudentHomeworkJdbc.selectAll();
        if(null == list || list.size()<=0){
            out.println("No data.");
        }else{
            for (StudentHomework sh : list2){
    %>
    <tr align="center">
        <td><%=sh.getId()%></td>
        <td><%=sh.getStudentId()%></td>
        <td><%=sh.getHomeworkId()%></td>
        <td><%=sh.getHomeworkTitle()%></td>
        <td><%=sh.getHomeworkContent()%></td>
        <td><%=sh.getCreateTime()%></td>
    </tr>
    <%
            }
        }%>
</table>
</body>
</html>
