package org.demo.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.demo.service.LoginService;

@WebServlet("/login")
public class LoginServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//�����û��ύ���˺ź�����
		String userName=request.getParameter("userName");
		String password=request.getParameter("password");
		System.out.println("�û�����"+userName+"-----------"+"���룺"+password);
		//����һ��LoginService���󣬽��û��������뽻�ɸ�Servlet����֤����
		LoginService service=new LoginService();
		boolean flag=service.checkUser(userName, password);
		//���ݷ��ص�boolean���ͽ����ʾ�û���Ϣ
		String message=flag?"success":"�˺Ż��������";
		response.setContentType("text/html;charset=utf-8");
		//ǰ��ʹ��ajax�ύ���������ʹ��response��������������Ϣд�ص�ǰ�������ҳ��
		response.getWriter().println(message);
	}
	
}
