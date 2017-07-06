package org.chat.listener;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.chat.bean.UserBean;

@WebListener
public class UserListListener implements ServletContextListener{
	
	/**
	 * ������ֹͣ��ʱ�򣬽������û��б��Ƴ�
	 */
	@Override
	public void contextDestroyed(ServletContextEvent event) {
		event.getServletContext().removeAttribute("userList");
		
	}

	/* ��ʼ��ʱwebʱ����һ���û��б������б�����������������
	 * (non-Javadoc)
	 * @see javax.servlet.ServletContextListener#contextInitialized(javax.servlet.ServletContextEvent)
	 */
	@Override
	public void contextInitialized(ServletContextEvent event) {
		//����һ���û��б�
		List<UserBean> userList = new ArrayList<UserBean>();
		//���û��б��浽��������
		event.getServletContext().setAttribute("userList", userList);
		
	}
	
}
