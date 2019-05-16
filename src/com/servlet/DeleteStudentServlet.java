package com.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Student;
import com.service.StudentService;

public class DeleteStudentServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String id = new String(req.getParameter("id").getBytes("ISO-8859-1"),"UTF-8");
		StudentService service = new StudentService();
		boolean result = service.deleteStudent(Integer.parseInt(id));
		if (result) {
			req.setAttribute("MSG", "É¾³ý³É¹¦");
		}else{
			req.setAttribute("MSG", "É¾³ýÊ§°Ü");
		}
		resp.sendRedirect("studentListServlet");
	}
}
