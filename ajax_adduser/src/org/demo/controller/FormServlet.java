package org.demo.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.demo.dao.UserDao;
import org.demo.entity.UserBean;
@WebServlet("/submit")
public class FormServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname = request.getParameter("user");
		String upwd = request.getParameter("pwd");
		int age=Integer.parseInt(request.getParameter("age"));
		String address=request.getParameter("addr");
		/*UserBean user=new UserBean();
		user.setName(uname);
		user.setPassword(upwd);
		user.setAge(age);
		user.setAddress(address);*/
		//�Ѳ������ý�ȥ���ڴ�֮ǰ������д�������췽�����вκ��޲Σ���
		UserBean user=new UserBean(uname,upwd,age,address);
		System.out.println(user);
		UserDao dao = new UserDao();
		dao.addUser(user);
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().write("��ӳɹ���");
	}
}
