package org.demo.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.demo.entity.UserBean;
import org.demo.service.CheckService;

@WebServlet("/userLogin")
public class UserLogin extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unused")
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserBean user=new UserBean();
		user.setUname(request.getParameter("userName"));
		user.setUpwd(request.getParameter("userPwd"));
		
		CheckService service=new CheckService();
		UserBean User=service.checkUser(user);
		request.setAttribute("User", User);
		System.out.println("用户名："+user.getUname());
		System.out.println("密码："+user.getUpwd());
		if(User!=null){
			request.getSession().setAttribute("User", User);
			request.getRequestDispatcher("HTML/2.jsp").forward(request, response);
		}else{
			response.sendRedirect("HTML/addUser.jsp");
			System.out.println("用户名或密码输入错误！");
		}
	}
	
}
