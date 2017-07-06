package org.order.servlet;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.order.service.OrderService;

import com.google.gson.Gson;
@WebServlet("/admin/adminIndex/updateOrder")
public class UpdateOrder extends HttpServlet{

	/**
	 * 修改订单状态
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("id"));
		OrderService service=new OrderService();
		int list=service.update(id);
		String json=new Gson().toJson(list);
//		System.out.println(json);
		response.setContentType("application/json;charset=utf-8");
		response.getWriter().write(json);
		
	}

}
