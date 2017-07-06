package org.order.servlet;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.order.bean.HelpType;
import org.order.dao.HelpTypeDao;

import com.google.gson.Gson;
@WebServlet("/admin/adminIndex/dddd")
public class FindHelpTypeServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HelpTypeDao dao=new HelpTypeDao();
		List<Map<String, Object>> list=dao.findHelpType();
		String json=new Gson().toJson(list);
		System.out.println(json);
		//设置响应类型
		response.setContentType("application/json;charset=utf-8");
		//响应输出
		response.getWriter().println(json);
	}
		
}
