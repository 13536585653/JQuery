package org.order.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.order.bean.Admin;
import org.order.dao.AdminDao;
@WebServlet("/admin/adminIndex/updateAdmin")
public class AdminPwd extends HttpServlet{

	/**
	 * 管理员的密码修改
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String opwd=request.getParameter("oldpwd");
		Admin admin=(Admin) request.getSession().getAttribute("admin");
		String pwd1=request.getParameter("pwd");
		String msg=null;
		if(opwd.equals(admin.getPwd())==false){
			msg="原密码不正确！！！！";
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().print(msg);
		}else{
		
		Admin a=new Admin();
		a.setName(admin.getName());
		a.setPwd(pwd1);
		
		AdminDao dao=new AdminDao();
		int n=dao.updatepwd(a);
		System.out.println(n);
		if(n>0){
			request.getSession().removeAttribute("admin");
		}
		msg="修改成功！";
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().print(msg);
		}
		
	}
	
		
}
