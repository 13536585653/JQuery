package org.order.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.order.service.BackupsService;

@WebServlet("/admin/adminIndex/recoverbackups")
public class Recoverbackups extends HttpServlet{

	/**
	 * 备份还原
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("name");
		BackupsService service=new BackupsService();
		boolean flag=service.recover(name);
		String msg= flag ? "恢复成功" : "恢复失败";
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().print(msg);

	}

}
