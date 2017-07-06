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
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//�����û��ύ����Ϣ
		String message = request.getParameter("msg");
		//�Ȼ�ȡ����������
		UserBean user = (UserBean)request.getSession().getAttribute("user");
		String sendUser = user.getUserName();
		System.out.println(sendUser);
		//����ϢȺ����������,�Ȼ�ȡ�û��б�
		@SuppressWarnings("unchecked")
		List<UserBean> userList = (List<UserBean>)request.getServletContext().getAttribute("userList");
		//ѭ���б���ȡÿһ�������ˣ�Ȼ����Ϣ����ÿһ���û�����Ϣ������
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
