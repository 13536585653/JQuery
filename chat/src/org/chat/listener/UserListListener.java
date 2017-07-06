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
	 * 当容器停止的时候，将整个用户列表移除
	 */
	@Override
	public void contextDestroyed(ServletContextEvent event) {
		event.getServletContext().removeAttribute("userList");
		
	}

	/* 初始化时web时创建一个用户列表，并将列表保存在上下文作用域
	 * (non-Javadoc)
	 * @see javax.servlet.ServletContextListener#contextInitialized(javax.servlet.ServletContextEvent)
	 */
	@Override
	public void contextInitialized(ServletContextEvent event) {
		//创建一个用户列表
		List<UserBean> userList = new ArrayList<UserBean>();
		//将用户列表保存到上下文中
		event.getServletContext().setAttribute("userList", userList);
		
	}
	
}
