package org.front.servlet;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.order.dao.JingxuanMenuDao;

import com.google.gson.Gson;
@WebServlet("/magashop/findJxByid")
public class FindJxByid extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("id"));
		JingxuanMenuDao dao=new JingxuanMenuDao();
		Map<String,Object> map=dao.findimgByid(id);
		String json=new Gson().toJson(map);
		//System.out.println(json);
		//������Ӧ����
		response.setContentType("application/json;charset=utf-8");
		//��Ӧ���
		response.getWriter().println(json);
		System.out.println(json);
	}
		
}
