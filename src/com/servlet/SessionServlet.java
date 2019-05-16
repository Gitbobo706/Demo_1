package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String info = req.getParameter("info");
		if(info!=null){
			req.setAttribute("requestInfo", info);
			HttpSession session = req.getSession();
			session.setAttribute("sessionInfo", info);
		}
		req.getRequestDispatcher("session.jsp").forward(req, resp);
	}
}
