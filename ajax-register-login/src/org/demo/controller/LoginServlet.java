package org.demo.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.demo.service.LoginService;
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName=request.getParameter("userName");
		String userPwd=request.getParameter("userPwd");
		System.out.println("用户名："+userName+"---------------"+"密码："+userPwd);
		
		LoginService service=new LoginService();
		boolean b1=service.findUser(userName, userPwd);
		String msg=b1==false?"登录失败！":"登录成功！";
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().println(msg);
	}
	
}
