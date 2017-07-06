package org.front.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.order.bean.UserBean;

import com.google.gson.Gson;
@WebServlet("/magashop/getName")
public class GetName extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserBean user= (UserBean) request.getSession().getAttribute("User");	
		if(user!=null){
			String name=user.getUname();
			System.out.println("ddddddddd"+name);
			String json=new Gson().toJson(name);
			response.setContentType("application/json;charset=utf-8");
			response.getWriter().println(json);
			}else{
				String json=null;
				response.setContentType("application/json;charset=utf-8");
				response.getWriter().println(json);
			}
			
			
	}
	
}
