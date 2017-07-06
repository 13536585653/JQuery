package org.front.servlet;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.order.dao.OrderDao;
import org.order.utils.GsonUtil;
@WebServlet("/magashop/selectOrderByName")
public class selectOrderByName extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String u_name=request.getParameter("u_name");
			OrderDao dao=new OrderDao();
			List<Map<String,Object>> list=dao.selectOrderByName(u_name);
			String json=GsonUtil.toJson2(list,"yyyy-MM-dd HH:mm:ss");
			response.setContentType("application/json;charset=utf-8");
			response.getWriter().println(json);
			System.out.println(json);
	}
}
