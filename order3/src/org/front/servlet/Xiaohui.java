package org.front.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
@WebServlet("/magashop/xiaohui")
public class Xiaohui extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();	
		session.invalidate();
		String  msg="您已安全退出菜府网上订餐平台";
		String json=new Gson().toJson(msg);
		response.setContentType("application/json;charset=utf-8");
		response.getWriter().println(json);
	}
	
}
