package org.chat.servlet;

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

	private static List<String> userLists = new ArrayList<String>();
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username") ;
		
		boolean isExist = userLists.contains(username) ;
		String path = "main.jsp" ;
		if(isExist) {
			path = "index.jsp?exist="+username ;
		} else {
			request.getSession().setAttribute("user", username);
			userLists.add(username) ;
		}
		response.sendRedirect(path);
	}

}
