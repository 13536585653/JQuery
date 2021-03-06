package org.front.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.order.bean.UserBean;
import org.order.service.CheckService;



@WebServlet("/magashop/log/login")
public class UserLogin extends HttpServlet{
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unused")
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserBean user=new UserBean();
		user.setUname(request.getParameter("userName"));
		user.setUpwd(request.getParameter("userPwd"));
	//	System.out.println(request.getAttribute("userName"));
		
		CheckService service=new CheckService();
		UserBean User=service.checkUser(user);

		if(User!=null){
			request.getSession().setAttribute("User", User);
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().println(User.getUname());}else{
			System.out.println("用户名或密码输入错误！");
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().println("用户名或密码输入错误！");
		}
	}
	
}
