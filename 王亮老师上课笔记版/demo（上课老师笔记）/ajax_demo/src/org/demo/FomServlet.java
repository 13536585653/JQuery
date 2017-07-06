package org.demo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/submit")
public class FomServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname = request.getParameter("userName");
		String age = request.getParameter("age");
		String sex = request.getParameter("sex");
		System.out.println(uname);
		System.out.println(age);
		System.out.println(sex);
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().println("Ìí¼Ó³É¹¦");
	}

}
