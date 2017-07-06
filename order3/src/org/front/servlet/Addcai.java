package org.front.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.order.bean.Order;
import org.order.service.OrderService;
/**
 * 购买菜的方法
 * @author Administrator
 *
 */
public class Addcai extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SimpleDateFormat dateFm = new SimpleDateFormat("yyyy-hh-mm-ss");
        String dateTime = dateFm.format(new java.util.Date());
        String s=dateTime.replace("-", "");
        int state=0;
		int num=Integer.parseInt(request.getParameter("num"));
		int id=Integer.parseInt(request.getParameter("id"));
		
		Order order=new Order();
		order.setO_m_id(id);
		order.setO_num(num);
		order.setO_number(s);
		order.setO_state(state);

		OrderService service=new OrderService();
		service.addorder(order);
	}

}
