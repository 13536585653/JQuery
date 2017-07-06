package org.demo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/test")
public class TestServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//����ajax�������������
		String uname = request.getParameter("userName");
		System.out.println(uname);
		uname+=",hello";
		response.setContentType("text/html;charset=utf-8");
		//ע�⣺��ʹ��ajax��Ӧ�ͻ���ʱ������ͨ��response��������������Ӧ������ʹ��request��ת����response���ض���
		response.getWriter().println(uname);
	}

}
