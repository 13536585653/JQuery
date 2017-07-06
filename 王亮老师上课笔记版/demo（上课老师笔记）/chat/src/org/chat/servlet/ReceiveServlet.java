package org.chat.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.chat.bean.UserBean;

@WebServlet("/receive")
public class ReceiveServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//���Լ�����Ϣ�����л�ȡ��Ϣ���ӵ�ǰ��session�л�ȡuser����
		UserBean user = (UserBean)request.getSession().getAttribute("user");
		//��user�����е���Ϣ�����л�ȡ��Ϣ,�����Ϣ�����ǿյģ���ô���̻߳�һֱ����
		try {
			String message = user.getQueue().take();
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().println(message);
			//ͨ��response��������������Ϣд�ؿͻ���
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

}
