package org.order.servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.order.dao.MenuDao;
import org.order.service.MenuService;

import com.google.gson.Gson;
@WebServlet("/admin/adminIndex/selectMT")
public class SelectMT extends HttpServlet{

	/**
	 * 查询指定id的菜单的信息
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		MenuService service2=new MenuService();
		String id=request.getParameter("id");
		System.out.println(id);
		if(id!=null){
			
			int ids=Integer.parseInt(id);
			Map<String ,Object> map=service2.select(ids);
			String json2=new Gson().toJson(map);
			System.out.println(json2);
			response.setContentType("application/json;charset=utf-8");
			response.getWriter().write(json2);
		}
		/*else{
			List<Map<String ,Object>> list=dao.selectMenu();	
			String json2=new Gson().toJson(list);
			response.setContentType("application/json;charset=utf-8");
			response.getWriter().write(json2);
			System.out.println(json2);
		}*/
	}
	
}
