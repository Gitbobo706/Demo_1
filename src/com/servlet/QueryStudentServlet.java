package com.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Student;
import com.service.StudentService;

public class QueryStudentServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String name = new String(req.getParameter("name").getBytes("ISO-8859-1"),"UTF-8");
		String age = new String(req.getParameter("age").getBytes("ISO-8859-1"),"UTF-8");
		String score = new String(req.getParameter("score").getBytes("ISO-8859-1"),"UTF-8");
		String sex = "";
		if (req.getParameter("sex")!=(null)) {
			 sex=new String(req.getParameter("sex").getBytes("ISO-8859-1"),"UTF-8");
		}
		Student student = new Student();
		student.setName(name);
		student.setSex(sex);
		if("".equals(age)){
			student.setAge(0);
		}else{
			student.setAge(Integer.parseInt(age));
		}		
		if("".equals(score)){
			student.setScore(0);
		}else{
			student.setScore(Integer.parseInt(score));
		}
		StudentService service = new StudentService();
		ArrayList<Student> list = service.queryStudentByRecord(student);
		req.setAttribute("list", list);
		req.getRequestDispatcher("list.jsp").forward(req, resp);
	}
}
