package org.order.servlet;

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

import com.google.gson.Gson;
@WebServlet("/admin/adminIndex/selectByNumber")
public class SelectOrderByNumber extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String n=request.getParameter("val");
		System.out.println(n);
		OrderDao dao=new OrderDao();
		List<Map<String,Object>> map=dao.selectOrderBymenber(n);
		//String json=new Gson().toJson(map);
		String json=GsonUtil.toJson2(map,"yyyy-MM-dd HH:mm:ss");
		
		System.out.println(json);
		response.setContentType("application/json;charset=utf-8");
		response.getWriter().println(json);
	}
		
}
