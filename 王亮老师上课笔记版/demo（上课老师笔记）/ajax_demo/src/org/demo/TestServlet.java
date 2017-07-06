package org.demo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/test")
public class TestServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//接受ajax请求过来的数据
		String uname = request.getParameter("userName");
		System.out.println(uname);
		uname+=",hello";
		response.setContentType("text/html;charset=utf-8");
		//注意：当使用ajax相应客户端时，必须通过response对象的输出流来响应，不能使用request的转发或response的重定向
		response.getWriter().println(uname);
	}

}
