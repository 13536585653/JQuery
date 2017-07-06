package org.demo.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.demo.entity.UserBean;
import org.demo.service.LoginService;
@WebServlet("/login")
public class LoginServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName=request.getParameter("userName");
		String password=request.getParameter("password");
		UserBean user=new UserBean();
		user.setUserName(userName);
		user.setPassword(password);
		LoginService service=new LoginService();
		boolean bl=service.checkUser(user);
		String message=bl?"success":"’À∫≈ªÚ√‹¬Î¥ÌŒÛ£°";
		response.setContentType("text/html;charset=utf-8");
		System.out.println(message);
		response.getWriter().println(message);
	}
	
}
