package org.demo.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.demo.dao.BookDao;
import org.demo.utils.GsonUtil;



@WebServlet("/findbooks")
public class FindBooksServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//创建dao,查询所有书籍信息
		BookDao dao=new BookDao();
		List<Map<String,Object>> list=dao.findBooks();
		/*//页面时ajax请求过来的，因此将list序列化成json对象
		//由于Gson对日期会自动化，那么当我们需要自定义日期格式的时候
		//可以使用GsonBuilder来指定日期的格式化类型
		GsonBuilder builder=new GsonBuilder();
		//格式化之后再调用create方法创建Gson实例
		Gson gson=builder.setDateFormat("yyyy-MM-dd").create();
		//通过gson对象序列化list
		String json=gson.toJson(list);*/
		String json=GsonUtil.toJson(list,"yyyy-MM-dd");
		//通过response的输出流将json写回浏览器
		//先设置response的响应类型为json类型
		response.setContentType("application/json;charset=utf-8");
		response.getWriter().println(json);
	}
	
}
