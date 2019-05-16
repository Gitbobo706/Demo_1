package com.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Student;
import com.service.StudentService;

public class StudentListServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		StudentService studentService = new StudentService();
		ArrayList<Student> list = studentService.listStudent();
		req.setAttribute("list", list);
		req.getRequestDispatcher("list.jsp").forward(req, resp);
	}
}
