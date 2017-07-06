package org.demo;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dao.UserDao;
import org.entity.UserBean;

import com.google.gson.Gson;

@WebServlet("/findlist")
public class FindUsersServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname = request.getParameter("userName");
		String age = request.getParameter("age");
		System.out.println(uname);
		System.out.println(age);
		UserDao dao = new UserDao();
		List<UserBean> list = dao.findUsers();
		//将list转换成json字符串
		String json = new Gson().toJson(list);
		System.out.println(json);
		//使用response响应回客户端
		//将相应类型设置为json类型
		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().println(json);
	}

}
