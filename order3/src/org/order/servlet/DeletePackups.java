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

@WebServlet("/admin/adminIndex/deletebackups")
public class DeletePackups extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("name");
		BackupsService service=new BackupsService();
		int n=service.delete(name);
	}

}
