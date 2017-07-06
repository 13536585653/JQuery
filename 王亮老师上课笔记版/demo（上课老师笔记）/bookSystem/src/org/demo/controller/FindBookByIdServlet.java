package org.demo.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.demo.service.FindBookByIdService;
import org.demo.utils.GsonUtil;

/**
 * Servlet implementation class FindBookByIdServlet
 */
@WebServlet("/findBookById")
public class FindBookByIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获得提交过来的书籍ID
		int bid=Integer.parseInt(request.getParameter("bid"));
		//创建业务层对象
		FindBookByIdService service=new FindBookByIdService();
		Map<String,Object> map=service.findBook(bid);
		//将map序列化成json对象
		String json= GsonUtil.toJson(map,"yyyy-MM-dd");
		//设置响应类型
		response.setContentType("application/json;charset=utf-8");
		//响应输出
		response.getWriter().println(json);
		System.out.println(json);
	}

}
