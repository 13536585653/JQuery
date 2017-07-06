package org.demo.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.demo.entity.Book;
import org.demo.service.AddBookService;
import org.demo.utils.GsonUtil;

/**
 * Servlet implementation class AddBookServlet
 */
@WebServlet("/addBook")
public class AddBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String bookName=request.getParameter("bookName");
		String createTime=request.getParameter("createTime");
		Date date=Date.valueOf(createTime);
		//将类型id装换成int类型
		int tid=Integer.parseInt(request.getParameter("tid"));
		//将表单数据封装到Book对象中
		Book book=new Book();
		book.setBname(bookName);
		book.setCreateTime(date);
		book.setTid(tid);
		//创建dao对象，保存
		AddBookService service=new AddBookService();
		List<Map<String,Object>> list=service.addBook(book);
		/*
		 * //将list序列成JSON对象
		GsonBuilder builder=new GsonBuilder();
		//格式化之后再调用create方法创建Gson实例
		Gson gson=builder.setDateFormat("yyyy-MM-dd").create();
		//通过gson对象序列化list
		String json=gson.toJson(list);
		//通过response的输出流将json写回浏览器
		//先设置response的响应类型为json类型
		 */		
		String json=GsonUtil.toJson(list,"yyyy-MM-dd");
		response.setContentType("application/json;charset=utf-8");
		response.getWriter().println(json);
	}
}
