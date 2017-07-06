package org.order.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.order.bean.Dishes;
import org.order.bean.PageBean2;
import org.order.dao.DishesDao;
import org.order.service.DishesService;
import org.order.utils.GsonUtil;

import com.google.gson.Gson;
@WebServlet("/admin/adminIndex/selectdishes")
public class Selectdishes extends HttpServlet{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

/***
 * 
 * 查询菜品的分类
 */
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int  pageNum =Integer.parseInt(request.getParameter("pageNum"));
			PageBean2 pageBean2=new PageBean2();
			pageBean2.setPageNum(pageNum);
			DishesService service=new DishesService();
			service.findDishesList(pageBean2);
			response.setContentType("application/json;charset=utf-8");
			String json=GsonUtil.toJson(pageBean2);
			response.getWriter().println(json);
			System.out.println(json);

	}

}
