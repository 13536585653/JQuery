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
		//从自己的消息队列中获取消息，从当前的session中获取user对象
		UserBean user = (UserBean)request.getSession().getAttribute("user");
		//从user对象中的消息队列中获取消息,如果消息队列是空的，那么次线程会一直阻塞
		try {
			String message = user.getQueue().take();
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().println(message);
			//通过response对象的输出流将消息写回客户端
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

}
