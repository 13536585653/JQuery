package org.front.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.front.service.SelectAllMenuService;
import org.order.bean.PageBean;
import org.order.utils.GsonUtil;
@WebServlet("/magashop/selectallmenu")
public class SelectAllMenu extends  HttpServlet{

	/**
	 * 查询所有菜
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int pageNum =Integer.parseInt(request.getParameter("pageNum"));
		PageBean pageBean=new PageBean();
		pageBean.setPageNum(pageNum);

		SelectAllMenuService service=new SelectAllMenuService();
		service.selectallmenu(pageBean);

		response.setContentType("application/json;charset=utf-8");
		String json=GsonUtil.toJson(pageBean,"yyyy-MM-dd");
		response.getWriter().println(json);
		System.out.println(json);
	}

}
