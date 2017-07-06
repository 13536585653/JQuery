package org.order.servlet;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.order.bean.Menu;
import org.order.service.MenuService;
import org.order.utils.GsonUtil;


@WebServlet("/admin/adminIndex/updatemenu")
public class Updatemenu extends HttpServlet{

	/**
	 * 修改菜单信息
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		@SuppressWarnings("unchecked")
		List<String> fileNames = (List<String>)request.getSession().getAttribute("fileNames");
		MenuService service=new MenuService();
		int id=Integer.parseInt(request.getParameter("ID"));
		String name=request.getParameter("Name");
		Float price=Float.parseFloat(request.getParameter("price"));
		String Note=request.getParameter("Note");
		int d_id=Integer.parseInt(request.getParameter("d_id"));
		Menu menu=new Menu();
		menu.setM_id(id);
		menu.setM_name(name);
		menu.setM_price(price);
		menu.setM_description(Note);
		menu.setD_id(d_id);
		if(fileNames!=null){
			for (String fileName : fileNames) {
				
				request.getSession().setAttribute("fname", fileName);			
			}
			String fname = (String) request.getSession().getAttribute("fname");

			menu.setM_img(fname);
			int n=service.update(menu);
			String msg = n == 0 ? "失败" : "成功";
			System.out.println(msg);
		}
		else{
			int n=service.update(menu);
			String msg = n == 0 ? "失败" : "成功";
			System.out.println(msg);
		}

	
	}

}
