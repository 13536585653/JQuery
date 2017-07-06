package org.order.servlet;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.order.bean.Menu;
import org.order.service.FindMenuService;

@WebServlet("/admin/adminIndex/remove")
public class RemoveJX extends HttpServlet{

	/**
	 * 移除精选菜
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("id"));
		Menu m=new Menu();
		m.setM_id(id);
		FindMenuService service=new FindMenuService();
		int n=service.remove(m);
		System.out.println(n);
	}

}
