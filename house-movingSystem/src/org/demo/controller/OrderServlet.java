package org.demo.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.demo.dao.OrderDao;
import org.demo.entity.HouseBean;
import org.demo.utils.GsonUtil;

@WebServlet("/order")
public class OrderServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sel=request.getParameter("sel");
		String radio=request.getParameter("radio");
		String orderDate=request.getParameter("orderDate");
		Date date=Date.valueOf(orderDate);
		String contacts=request.getParameter("contacts");
		String phone=request.getParameter("phone");
		Byte hstatus=0;
		System.out.println("个人信息："+sel+"  "+radio+"  "+orderDate+"  "+contacts+"  "+phone+"  "+hstatus);
		
		HouseBean house=new HouseBean();
		house.setHarea(sel);
		house.setHcartype(radio);
		house.setHmovedate(date);
		house.setHcontact(contacts);
		house.setHphone(phone);
		house.setHstatus(hstatus);
		
		OrderDao dao=new OrderDao();
		int i=dao.addOrder(house);
		List<Map<String,Object>> list=dao.findHouse();
		request.getSession().setAttribute("list", list);
		String msg=i==0?"预约失败":"预约成功";
		String json=GsonUtil.toJson(msg,"yyyy-MM-dd");
		response.setContentType("application/json;charset=utf-8");
		response.getWriter().println(json);
		
	}
	
}
