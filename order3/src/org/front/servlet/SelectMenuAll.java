package org.front.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.front.dao.MenuDao;
import org.order.bean.Menu;

import com.google.gson.Gson;
@WebServlet("/magashop/selectmenu")
public class SelectMenuAll extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MenuDao dao=new MenuDao();
		List<Menu> list=dao.selectMenuAll();
		String json=new Gson().toJson(list);
		response.setContentType("application/json;charset=utf-8");
		response.getWriter().println(json);
		System.out.println(json);
	}

}
