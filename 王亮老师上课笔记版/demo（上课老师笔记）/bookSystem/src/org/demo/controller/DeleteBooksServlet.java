package org.demo.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.demo.service.DelBooksService;
import org.demo.utils.GsonUtil;
@WebServlet("/removeBooks")
public class DeleteBooksServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	public void service(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
		//接受参数
		String[] bids=request.getParameterValues("bid");
		System.out.println("删除项的长度："+bids.length);
		//将参数交由给业务层进行处理
		DelBooksService service =new DelBooksService();
		List<Map<String,Object>> list=service.removeBooks(bids);
		//将list序列化成json
		String json=GsonUtil.toJson(list,"yyyy-MM-dd");
		response.setContentType("application/json;charset=utf-8");
		response.getWriter().println(json);
	}
}
