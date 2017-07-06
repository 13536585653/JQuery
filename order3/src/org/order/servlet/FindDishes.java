package org.order.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.order.bean.Dishes;
import org.order.dao.DishesDao;

import com.google.gson.Gson;
@WebServlet("/admin/adminIndex/FindDishe")
public class FindDishes extends HttpServlet{

	/**
	 * 添加菜单的时候查询类型
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DishesDao dao=new DishesDao();
		List<Dishes> list=dao.selectdishes();
		String json=new Gson().toJson(list);
		response.setContentType("application/json;charset=utf-8");
		response.getWriter().write(json);
		System.out.println(json);
	}

}
