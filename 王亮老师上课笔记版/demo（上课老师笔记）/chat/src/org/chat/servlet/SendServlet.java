package org.chat.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.chat.bean.UserBean;

@WebServlet("/send")
public class SendServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//接受用户提交的消息
		String message = request.getParameter("msg");
		//先获取发送人姓名
		UserBean user = (UserBean)request.getSession().getAttribute("user");
		String sendUser = user.getUserName();
		//将消息群发给所有人,先获取用户列表
		List<UserBean> userList = (List<UserBean>)request.getServletContext().getAttribute("userList");
		//循环列表，获取每一个接收人，然后将消息放入每一个用户的消息队列中
		for (UserBean userBean : userList) {
			try {
				userBean.getQueue().put(sendUser+" : "+message);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
