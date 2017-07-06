package org.front.servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.order.bean.Menu;
import org.order.bean.UserBean;
import org.order.service.MenuService;
@WebServlet("/magashop/gouwc")
public class GWCselect extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int c_id=Integer.parseInt(request.getParameter("c_id"));
		if(request.getSession().getAttribute("User")!=null){
			int num=Integer.parseInt(request.getParameter("num"));
			int id=Integer.parseInt(request.getParameter("id"));
			Menu menu=new Menu();
			menu.setM_id(id);
			System.out.println(id);
			MenuService service=new MenuService();
			UserBean user=(UserBean) request.getSession().getAttribute("User");
			float s=user.getRtype().getR_ids();
			System.out.println(s);
			Map<String ,Object> map=service.selectById(id,num,s);
			map.put("c_id", c_id);
			request.setAttribute("map",map);
			System.out.println(map);
			request.getRequestDispatcher("demo.jsp").forward(request, response);
		}else{
			response.sendRedirect("log/index.html");
		}
	}

	
}
