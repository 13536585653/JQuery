package org.order.servlet;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.order.service.FindMenuByNameService;

import com.google.gson.Gson;
@WebServlet("/admin/adminIndex/selectByName")
public class SelectMenuByName extends HttpServlet{

	/**
	 * 模糊查询
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
	
		int m_id="".equals(request.getParameter("value")) ? null :Integer.parseInt(request.getParameter("value"));
		String key ="".equals(request.getParameter("keywords")) ? null : request.getParameter("keywords");
		System.out.println(m_id);
		System.out.println(key);
		FindMenuByNameService service=new FindMenuByNameService();
		List<Map<String,Object>> list=service.find(m_id,key);
		String json=new Gson().toJson(list);
//		System.out.println(json);
		response.setContentType("application/json;charset=utf-8");
		response.getWriter().write(json);
		
		System.out.println(json);
	}

}
