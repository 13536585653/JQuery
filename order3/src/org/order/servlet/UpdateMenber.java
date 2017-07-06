package org.order.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.order.bean.UserBean;
import org.order.service.UserService;
import org.order.utils.GsonUtil;
@WebServlet("/admin/adminIndex/update2")
public class UpdateMenber extends HttpServlet{

	/**
	 * 修改会员的信息
	 */
	private static final long serialVersionUID = 1L;

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
/*			System.out.println(request.getParameter("d_id"));
			System.out.println(request.getParameter("Name"));*/
			UserService service=new UserService();
			int n=service.update2(u);
			System.out.println(n);

		
	}

}
