package org.demo.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/userLoginServlet")
public class UserLoginServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	public void service(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{	
				//接收用户名
				String userName = request.getParameter("userName");
				request.getSession().getAttribute("serviceMsg");
				response.sendRedirect("html/userChat.jsp");
				}

			}