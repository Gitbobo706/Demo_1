package com.servlet;

import java. io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Student;
import com.service.StudentService;

public class AddStudentServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
			req.getRequestDispatcher("add.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String name = new String(req.getParameter("name").getBytes("ISO-8859-1"),"UTF-8");
		String sex = new String(req.getParameter("sex").getBytes("ISO-8859-1"),"UTF-8");
		String age = new String(req.getParameter("age").getBytes("ISO-8859-1"),"UTF-8");
		String score = new String(req.getParameter("score").getBytes("ISO-8859-1"),"UTF-8");
		Student student = new Student();
		student.setName(name);
		student.setSex(sex);
		student.setAge(Integer.parseInt(age));
		student.setScore(Integer.parseInt(score));
		StudentService service = new StudentService();
		boolean result = service.addStudent(student);
		if (result) {
			req.setAttribute("MSG", "增加成功");
			ArrayList<Student> list = service.listStudent();
			req.setAttribute("list", list);
			req.getRequestDispatcher("list.jsp").forward(req, resp);
		}else {
			req.setAttribute("MSG", "增加失败");
			req.getRequestDispatcher("add.jsp").forward(req, resp);
		}
	}
}
