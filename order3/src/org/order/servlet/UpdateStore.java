package org.order.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.order.bean.Store;
import org.order.dao.StroeDao;
@WebServlet("/admin/adminIndex/updateStore")
public class UpdateStore extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4528987926842377315L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Store s=new Store();
		s.setS_name(request.getParameter("shopname"));
		s.setS_tel(request.getParameter("phone"));
		s.setS_addr(request.getParameter("address"));
		s.setS_email(request.getParameter("email"));
		s.setS_unit(request.getParameter("goodattrdefault"));
		s.setS_state(Integer.parseInt(request.getParameter("state")));
		s.setS_way(Integer.parseInt(request.getParameter("is_daopay")));
		s.setS_wux(Integer.parseInt(request.getParameter("is_onlinepay")));
		s.setS_business(request.getParameter("time"));
		StroeDao dao=new StroeDao();
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		@SuppressWarnings("unchecked")
		List<String> fileNames2 = (List<String>)request.getSession().getAttribute("fileNames2");
		if(fileNames2!=null){
		for (String fileName : fileNames2) {
				
				request.getSession().setAttribute("fname", fileName);
				System.out.println(request.getSession().getAttribute("fname"));
			}
			String img=(String) request.getSession().getAttribute("fname");
			s.setS_img(img);
			request.getSession().removeAttribute("fname");
			int n=dao.update(s);
			System.out.println(n);
		}
		int n=dao.Update2(s);
		System.out.println(n);
		
	}
	

}
