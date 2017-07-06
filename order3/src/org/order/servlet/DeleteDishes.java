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
import org.order.utils.GsonUtil;



@WebServlet("/admin/adminIndex/deleteDises")
public class DeleteDishes extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4209338375744419923L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id[]=request.getParameterValues("d_id");
		DishesService service =new DishesService();
		if(id!=null){
			int[] list=service.delete(id);
			System.out.println(list.length);
		}else{
			int id1=Integer.parseInt(request.getParameter("id"));
			int list=service.delete1(id1);
			System.out.println(list);
		}
		
			

		
	}

}
