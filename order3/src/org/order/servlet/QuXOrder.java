package org.order.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.order.service.OrderService;

import com.google.gson.Gson;

@WebServlet("/admin/adminIndex/qux")
public class QuXOrder extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("id"));
		OrderService service=new OrderService();
		int list=service.quxorder(id);
		String msg= list == 0 ? "取消失败" : "已取消";
		String json=new Gson().toJson(msg);
//		System.out.println(json);
		response.setContentType("html/text;charset=utf-8");
		response.getWriter().write(json);
		
	}

}
