package org.front.servlet;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.order.dao.HelpWentiDao;

import com.google.gson.Gson;
@WebServlet("/magashop/selectAllWenti")
public class SelectAllWenti extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			System.out.println("fguhgftdfhjgjkhghfhdg");
		HelpWentiDao dao=new HelpWentiDao();
			List<Map<String,Object>> list=dao.FindWenti();
			String json=new Gson().toJson(list);
			response.setContentType("application/json;charset=utf-8");
			response.getWriter().println(json);
			System.out.println(json);
	}
}
