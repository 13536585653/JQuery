package org.front.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.front.dao.CarDao;
import org.order.bean.MyCat;
import org.order.bean.UserBean;
import org.order.utils.GsonUtil;
@WebServlet("/magashop/selectcar")
public class SelectCar extends HttpServlet{

	
	/**
	 * 
	 * 列出购物车的商品
	 */
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserBean user=(UserBean) request.getSession().getAttribute("User");
		if(user!=null){
			int userid=user.getUid();
			MyCat c=new MyCat();
			c.setC_uid(userid);
			CarDao dao=new CarDao();
			List<MyCat> list=dao.selectcar(c);
			System.out.println(list);
			request.setAttribute("list", list);
			request.getRequestDispatcher("shopping_cart2.jsp").forward(request, response);
		}
	}

	
	
}
