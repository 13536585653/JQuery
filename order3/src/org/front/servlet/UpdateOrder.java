package org.front.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.order.bean.Order;
import org.order.dao.OrderDao;
import org.order.utils.GsonUtil;
@WebServlet("/magashop/update")
public class UpdateOrder extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Order order=new Order();
		order.setO_number(request.getParameter("number"));
		order.setO_way(request.getParameter("baidulbspay_pay_name"));
		int  state=1;
		order.setO_state(state);
		OrderDao dao=new OrderDao();
		int n=dao.update(order);
		String json=GsonUtil.toJson(n);
		response.setContentType("application/json;charset=utf-8");
		response.getWriter().println(json);
	}

}
