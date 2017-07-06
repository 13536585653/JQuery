package org.order.servlet;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.order.bean.HelpWenti;
import org.order.dao.HelpWentiDao;

import com.google.gson.Gson;
@WebServlet("/admin/adminIndex/selectWentiById")
public class SelectWentiById extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("id"));
		HelpWentiDao dao=new HelpWentiDao();
		Map<String, Object> list=dao.getWentiById(id);
		String json=new Gson().toJson(list);
		response.setContentType("application/json;charset=utf-8");
		response.getWriter().write(json);
		System.out.println(json);
	}
	
}
