package org.demo.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.demo.service.FindBookByIdService;
import org.demo.utils.GsonUtil;

/**
 * Servlet implementation class FindBookByIdServlet
 */
@WebServlet("/findBookById")
public class FindBookByIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//����ύ�������鼮ID
		int bid=Integer.parseInt(request.getParameter("bid"));
		//����ҵ������
		FindBookByIdService service=new FindBookByIdService();
		Map<String,Object> map=service.findBook(bid);
		//��map���л���json����
		String json= GsonUtil.toJson(map,"yyyy-MM-dd");
		//������Ӧ����
		response.setContentType("application/json;charset=utf-8");
		//��Ӧ���
		response.getWriter().println(json);
		System.out.println(json);
	}

}
