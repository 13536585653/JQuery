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
import org.order.dao.OrderDao;
import org.order.service.OrderService;
import org.order.utils.GsonUtil;

import com.google.gson.Gson;
@WebServlet("/admin/adminIndex/selectorder")
public class Selectorder extends HttpServlet{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7344810811990802520L;

	/**
	 * 
	 * 查询所有订单
	 */
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int pageNum =Integer.parseInt(request.getParameter("pageNum"));
		PageBean pageBean=new PageBean();
		pageBean.setPageNum(pageNum);
		OrderService service=new OrderService();
		service.selectorder(pageBean);
		response.setContentType("application/json;charset=utf-8");
		String json=GsonUtil.toJson2(pageBean,"yyyy-MM-dd HH:mm:ss");
		response.getWriter().println(json);
		System.out.println(json);
	}

}
