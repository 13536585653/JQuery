package com.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//定义一个List集合,用于存放登录用户
	private List<String> onlineList = new ArrayList<String>() ;
	

	
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");

		boolean isExist = onlineList.contains(username);
		
		
		String path = "main.jsp";
		if (isExist) {
			path = "login.jsp?exist=" + username;
		} else {
			request.getSession().setAttribute("user", username);
			onlineList.add(username);
		}
		
		response.sendRedirect(path);

	}

}
