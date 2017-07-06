package org.order.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.order.bean.Admin;
import org.order.service.AdminService;

@WebServlet("/adminServlet")
public class AdminServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String realYzm=(String) request.getSession().getAttribute("randomString");
		String josn = null;
		if(request.getParameter("yzm").equals(realYzm)){
			
			Admin admin = new Admin();
			admin.setName(request.getParameter("admin"));
			admin.setPwd(request.getParameter("pwd"));    
			
			AdminService service = new AdminService();
			System.out.println(request.getParameter("admin"));
			System.out.println(request.getParameter("pwd"));
			admin = service.checkAdmin(admin);//
			
			if(admin != null){
					response.setContentType("text/html;charset=utf-8");
					request.getSession().setAttribute("admin", admin);
					response.getWriter().println(admin.getName());
				}else{
					josn = "0"; //�û�����ȷ
					response.getWriter().println(josn);
				}
			}
			else{
			josn = "1";//��֤�벻��ȷ
			response.getWriter().println(josn);
		}
		
	}

}
