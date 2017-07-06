package org.order.servlet;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.order.bean.PageBean;
import org.order.bean.PageBean2;
import org.order.dao.MenuDao;
import org.order.service.FindMenuService;
import org.order.service.FindWentiService;
import org.order.service.MenuService;
import org.order.utils.GsonUtil;

import com.google.gson.Gson;
@WebServlet("/admin/adminIndex/selectmenu")
public class SelectMenu extends HttpServlet{

	/**
	 * 
	 * 查询菜单
	 */
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int pageNum =Integer.parseInt(request.getParameter("pageNum"));
		System.out.println(pageNum);
		PageBean2 pageBean2=new PageBean2();
		pageBean2.setPageNum(pageNum);

		FindMenuService service=new FindMenuService();
		service.findBookList(pageBean2);
		response.setContentType("application/json;charset=utf-8");
		String json=GsonUtil.toJson(pageBean2,"yyyy-MM-dd");
		response.getWriter().println(json);
		System.out.println(json);
		
		
		
		
		
		
		
		
		
		
		
		
		
		/*MenuDao dao=new MenuDao();
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
		else{
			List<Map<String ,Object>> list=dao.selectMenu();	
			String json2=new Gson().toJson(list);
			response.setContentType("application/json;charset=utf-8");
			response.getWriter().write(json2);
			System.out.println(json2);
		}*/
		
	}

}
