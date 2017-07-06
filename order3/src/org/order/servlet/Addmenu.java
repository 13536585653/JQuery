package org.order.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.order.bean.Menu;
import org.order.service.MenuService;

import com.google.gson.Gson;
@WebServlet("/admin/adminIndex/addmenu")
public class Addmenu extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest reqeust, HttpServletResponse response) throws ServletException, IOException {
		reqeust.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		@SuppressWarnings("unchecked")
		List<String> fileNames = (List<String>)reqeust.getSession().getAttribute("fileNames");;
		if(fileNames!=null){
			for (String fileName : fileNames) {

				System.out.println(fileName);
				reqeust.getSession().setAttribute("fname", fileName);	
				
			}
		}
		

		String fname = (String) reqeust.getSession().getAttribute("fname");
		System.out.println(fname);
		Menu menu=new Menu();
		menu.setD_id(Integer.parseInt(reqeust.getParameter("value")));
		menu.setM_name(reqeust.getParameter("name"));
		menu.setM_price(Float.parseFloat(reqeust.getParameter("price")));
		menu.setM_description(reqeust.getParameter("description"));
		menu.setM_img(fname);
		MenuService service=new MenuService();
		int n=service.checkMenu(menu);
		String json=new Gson().toJson(n);
//		System.out.println(json);
		response.setContentType("html/text;charset=utf-8");
		response.getWriter().write(json);
		System.out.println(json);
	}

}
