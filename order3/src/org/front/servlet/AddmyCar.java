package org.front.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.front.service.CarService;
import org.order.bean.MyCat;
import org.order.bean.UserBean;
import org.order.utils.GsonUtil;
@WebServlet("/magashop/addcar")
public class AddmyCar extends HttpServlet{

	
	/**
	 * 
	 * 购物车servlet
	 */
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserBean user=(UserBean) request.getSession().getAttribute("User");
		int n=0;
		if(user!=null){
			int userid=user.getUid();
			
			int m_id =Integer.parseInt(request.getParameter("id"));
			int num=Integer.parseInt(request.getParameter("num"));
			
			MyCat c=new MyCat();
			c.setC_mid(m_id);
			c.setC_uid(userid);
			c.setNum(num);			
			CarService service=new CarService();
			n=service.check(c);
			System.out.println(n);
			String json=GsonUtil.toJson(n);
			response.setContentType("application/json;charset=utf-8"); //������Ӧ��ʽ
			response.getWriter().println(json);
		}else{
			String json=GsonUtil.toJson(n);
			response.setContentType("application/json;charset=utf-8"); //������Ӧ��ʽ
			response.getWriter().println(json);
		}
	}

}
