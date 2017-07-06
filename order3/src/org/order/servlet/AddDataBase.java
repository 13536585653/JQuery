package org.order.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.order.bean.Backups;
import org.order.service.BackupsService;
import org.order.utils.GsonUtil;
@WebServlet("/admin/adminIndex/addDataBase")
public class AddDataBase extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String str=request.getParameter("date");
		BackupsService service=new BackupsService();
		int n=service.addDataBase(str);
		System.out.println(n);
		
	}

}
