package com.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Student;
import com.service.StudentService;

public class UpdateStudentServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		StudentService service = new StudentService();
		Student s = service.queryStudentById(id);
		req.setAttribute("student", s);
		req.getRequestDispatcher("update.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String id = new String(req.getParameter("id").getBytes("ISO-8859-1"),"UTF-8");
		String name = new String(req.getParameter("name").getBytes("ISO-8859-1"),"UTF-8");
		String sex = new String(req.getParameter("sex").getBytes("ISO-8859-1"),"UTF-8");
		String age = new String(req.getParameter("age").getBytes("ISO-8859-1"),"UTF-8");
		String score = new String(req.getParameter("score").getBytes("ISO-8859-1"),"UTF-8");
		Student s = new Student();
		s.setId(Integer.parseInt(id));
		s.setName(name);
		s.setSex(sex);
		s.setAge(Integer.parseInt(age));
		s.setScore(Integer.parseInt(score));
		StudentService service = new StudentService();
		boolean result = service.updateStudent(s);
		if(result){
			req.setAttribute("MSG", "修改成功");
			resp.sendRedirect("studentListServlet");
		}else{
			req.setAttribute("MSG", "修改失败");
			req.setAttribute("student", s);
			req.getRequestDispatcher("update.jsp").forward(req, resp);
		}
	}
}
