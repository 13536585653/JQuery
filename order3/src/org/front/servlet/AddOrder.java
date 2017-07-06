package org.front.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.front.dao.CarDao;
import org.order.bean.Order;
import org.order.bean.UserBean;
import org.order.service.OrderService;

import com.google.gson.Gson;
@WebServlet("/magashop/addOrder")
public class AddOrder extends HttpServlet{

	/**
	 * 添加订单
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserBean user=(UserBean) request.getSession().getAttribute("User");
		String  c_id=request.getParameter("c_id");
		if( c_id!=""){
			if(user!=null){
				int userid=user.getUid();
				String message=request.getParameter("message");
				String name=request.getParameter("name");
				int id=Integer.parseInt(request.getParameter("id"));
				int num=Integer.parseInt(request.getParameter("num"));
				Float price=Float.parseFloat(request.getParameter("price"));
				SimpleDateFormat dateFm = new SimpleDateFormat("yyyy-hh-mm-ss"); // 格式化当前系统日期
		        String dateTime = dateFm.format(new java.util.Date());
		        String s=dateTime.replace("-", "");
				Order order=new Order();
				order.setO_num(num);
				order.setO_sum(price);
				order.setO_number(s);
				order.setO_m_id(id);
				order.setO_u_id(userid);
				order.setMessage(message);
				OrderService service=new OrderService();
				int n=service.addorder(order);
				if(n>0){
					CarDao dao=new CarDao();
					int cid=Integer.parseInt(c_id);
					int x=dao.delete(cid,userid);
					System.out.println("gwc"+x);
					request.setAttribute("price", price);
					request.setAttribute("num", num);
					request.setAttribute("number", s);
					request.setAttribute("name", name);
					request.getRequestDispatcher("payment.jsp").forward(request, response);
				}
			}
			
		}
		else{
			System.out.println("ssssssssssssssssssssssssssssssssssss");
			int userid=user.getUid();
			String message=request.getParameter("message");
			String name=request.getParameter("name");
			int id=Integer.parseInt(request.getParameter("id"));
			int num=Integer.parseInt(request.getParameter("num"));
			Float price=Float.parseFloat(request.getParameter("price"));
			SimpleDateFormat dateFm = new SimpleDateFormat("yyyy-hh-mm-ss"); // 格式化当前系统日期
	        String dateTime = dateFm.format(new java.util.Date());
	        String s=dateTime.replace("-", "");
			Order order=new Order();
			order.setO_num(num);
			order.setO_sum(price);
			order.setO_number(s);
			order.setO_m_id(id);
			order.setO_u_id(userid);
			order.setMessage(message);
			OrderService service=new OrderService();
			int n=service.addorder(order);
			if(n>0){
				
				request.setAttribute("price", price);
				request.setAttribute("num", num);
				request.setAttribute("number", s);
				request.setAttribute("name", name);
				request.getRequestDispatcher("payment.jsp").forward(request, response);
			}
		}
		
	}

}
