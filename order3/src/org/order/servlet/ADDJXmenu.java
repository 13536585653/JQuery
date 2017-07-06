package org.order.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.order.dao.JingxuanMenuDao;
@WebServlet("/admin/adminIndex/addjx")
public class ADDJXmenu extends HttpServlet{

	/**
	 * 从所有菜中添加 精选菜
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("id"));
		JingxuanMenuDao dao=new JingxuanMenuDao();
		int n=dao.uploat(id);
	}
	

}
