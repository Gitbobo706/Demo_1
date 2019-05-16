package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.User;
import com.service.UserService;

public class RegisterServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.getRequestDispatcher("register.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String username = new String(req.getParameter("username").getBytes("ISO-8859-1"),"UTF-8");
		String password = new String(req.getParameter("password").getBytes("ISO-8859-1"),"UTF-8");
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		UserService service = new UserService();
		int result = service.registerUser(user);
		if (result == 1) {
			req.setAttribute("MSG", "注册成功");
			req.getRequestDispatcher("login.jsp").forward(req, resp);
		}else if(result == -1){
			req.setAttribute("MSG", "该用户名已存在");
			req.getRequestDispatcher("register.jsp").forward(req, resp);
		}else{
			req.setAttribute("MSG", "注册失败");
			req.getRequestDispatcher("register.jsp").forward(req, resp);
		}
	}
}
