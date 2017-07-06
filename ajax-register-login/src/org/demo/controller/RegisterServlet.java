package org.demo.controller;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.demo.dao.UserDao;
import org.demo.entity.UsersBean;
@WebServlet("/registerServlet")
public class RegisterServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname=request.getParameter("uname");
		String upassword=request.getParameter("upassword");
		String usex=request.getParameter("usex");
		int uage=Integer.parseInt(request.getParameter("uage"));
		String unum=request.getParameter("unum");
		String uaddress=request.getParameter("uaddress");
		
		UsersBean user=new UsersBean();
		user.setUname(uname);
		user.setUpassword(upassword);
		user.setUsex(usex);
		user.setUage(uage);
		user.setUnum(unum);
		user.setUaddress(uaddress);
		user.setUregTime(new Timestamp(System.currentTimeMillis()));
		
		
		UserDao dao=new UserDao();
		boolean users=dao.addUser(user);
		String msg=users==false?"×¢²á³É¹¦£¡":"×¢²áÊ§°Ü£¡";
		System.out.println(msg);
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().println(msg);
	}
	
}
