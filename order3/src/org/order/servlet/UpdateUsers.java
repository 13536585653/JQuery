package org.order.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.order.bean.UserBean;
import org.order.service.UserService;



@WebServlet("/admin/adminIndex/update1")
public class UpdateUsers extends HttpServlet{

	/**
	 * 修改用户或会员的状态
	 */
	private static final long serialVersionUID = -6102544657995564024L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			UserBean u=new UserBean();
			u.setUid(Integer.parseInt(request.getParameter("ID")));
			u.setUname(request.getParameter("Name"));
			u.setUsex(request.getParameter("sex"));
			u.setUtel(request.getParameter("tel"));
			u.setUaddr(request.getParameter("addr"));
			u.setUemail(request.getParameter("email"));
			u.setRid(Integer.parseInt(request.getParameter("d_id")));
			System.out.println(request.getParameter("d_id"));
			
			UserService service=new UserService();
			int n=service.update(u);
			System.out.println(n);

	}

}
