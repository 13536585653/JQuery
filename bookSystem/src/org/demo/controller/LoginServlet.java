package org.demo.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.demo.service.LoginService;

@WebServlet("/login")
public class LoginServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//接收用户提交的账号和密码
		String userName=request.getParameter("userName");
		String password=request.getParameter("password");
		System.out.println("用户名："+userName+"-----------"+"密码："+password);
		//创建一个LoginService对象，将用户名和密码交由给Servlet做验证处理
		LoginService service=new LoginService();
		boolean flag=service.checkUser(userName, password);
		//依据返回的boolean类型结果提示用户信息
		String message=flag?"success":"账号或密码错误！";
		response.setContentType("text/html;charset=utf-8");
		//前端使用ajax提交，因此这里使用response对象的输出流将信息写回当前那请求的页面
		response.getWriter().println(message);
	}
	
}
