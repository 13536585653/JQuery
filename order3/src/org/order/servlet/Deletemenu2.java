package org.order.servlet;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.order.service.MenuService;
import org.order.utils.GsonUtil;


@WebServlet("/admin/adminIndex/deletemenu")
public class Deletemenu2 extends HttpServlet{

	/**
	 * 当个删除的servlet
	 */
	private static final long serialVersionUID = -2134302252745515084L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id[]=request.getParameterValues("m_id");
		MenuService service =new MenuService();
		if(id!=null){
			int n []=service.deletemenu(id);		
		}else{
			int id1=Integer.parseInt(request.getParameter("id"));
		int n=service.delete1(id1);
		String msg = n == 0 ? "失败" : "成功";
		System.out.println(msg);
		}
	}

}
