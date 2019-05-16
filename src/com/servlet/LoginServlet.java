package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.User;
import com.service.UserService;

public class LoginServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String username = new String(req.getParameter("username").getBytes("ISO-8859-1"),"UTF-8");
		String password = new String(req.getParameter("password").getBytes("ISO-8859-1"),"UTF-8");
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		UserService service = new UserService();
		int result  = service.loginUser(user);
		if (result == 1) {
			Cookie cookie = new Cookie("username",username);
			resp.addCookie(cookie);
			req.setAttribute("MSG", "登陆成功");
			resp.sendRedirect("studentListServlet");
		}else if(result == 0){
			req.setAttribute("MSG", "密码错误");
			req.getRequestDispatcher("login.jsp").forward(req, resp);
		}else {
			req.setAttribute("MSG", "用户名不存在");
			req.getRequestDispatcher("login.jsp").forward(req, resp);			
		}
	}
}
