package org.demo.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.demo.dao.BTypeDao;
import org.demo.entity.BType;

import com.google.gson.Gson;

/**
 * Servlet implementation class FindBookTypeServlet
 */
@WebServlet("/findBookTypes")
public class FindBookTypeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BTypeDao dao=new BTypeDao();
		List<BType> list=dao.findType();
		//将list序列成JSON对象
		String json=new Gson().toJson(list);
		//设置响应类型
		response.setContentType("application/json;charset=utf-8");
		//响应输出
		response.getWriter().println(json);
	}
}
