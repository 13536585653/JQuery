package org.order.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.order.bean.Dishes;
import org.order.service.DishesService;

import com.google.gson.Gson;


@WebServlet("/admin/adminIndex/addDishes")
public class AddDishes extends HttpServlet{
/**
	 * 
	 */
	private static final long serialVersionUID = 7448520789600626818L;

/**
 * 
 * 添加菜品分类的servlet
 */
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Dishes d=new Dishes();
		d.setD_type(request.getParameter("type"));
//		System.out.println(s);
		DishesService service=new DishesService();
		int n=service.addDishes(d);
		if(n==0){
			String json=new Gson().toJson(n);
			System.out.println(json);
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().write(json);
		}
		else{
			List<Dishes> list=service.selectDishes();
			String json=new Gson().toJson(list);
//			System.out.println(json);
			response.setContentType("application/json;charset=utf-8");
			response.getWriter().write(json);
		}

	}

}
