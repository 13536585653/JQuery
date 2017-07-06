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
import org.order.utils.GsonUtil;
@WebServlet("/order-index/findDishes")
public class findDishesServlet2 extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//System.out.println();
		DishesDao dao=new DishesDao();
		List<Dishes> list=dao.selectdishes();
		String json=GsonUtil.toJson(list);
		response.setContentType("application/json;charset=utf-8"); //������Ӧ��ʽ
		response.getWriter().println(json); //��Ӧ���
		//System.out.println(json);
		System.out.println(json);
	}
			
}
