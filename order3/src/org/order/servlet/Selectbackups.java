package org.order.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.order.bean.Backups;
import org.order.bean.PageBean2;
import org.order.dao.BackupsDao;
import org.order.service.BackupsService;
import org.order.service.FindMenuService;
import org.order.utils.GsonUtil;

@WebServlet("/admin/adminIndex/selectbackups")
public class Selectbackups extends HttpServlet{

	/**
	 * 查询所有备份
	 */
	private static final long serialVersionUID = 8390874981000225643L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int pageNum =Integer.parseInt(request.getParameter("pageNum"));
		System.out.println(pageNum);
		PageBean2 pageBean2=new PageBean2();
		pageBean2.setPageNum(pageNum);

		BackupsService service=new BackupsService();
		service.selectbackups(pageBean2);
		response.setContentType("application/json;charset=utf-8");
		String json=GsonUtil.toJson(pageBean2,"yyyy-MM-dd HH:mm:ss");
		response.getWriter().println(json);
		System.out.println(json);
	}

	
}
