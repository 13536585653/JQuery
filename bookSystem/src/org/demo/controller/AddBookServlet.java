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
		//������idװ����int����
		int tid=Integer.parseInt(request.getParameter("tid"));
		//�������ݷ�װ��Book������
		Book book=new Book();
		book.setBname(bookName);
		book.setCreateTime(date);
		book.setTid(tid);
		//����dao���󣬱���
		AddBookService service=new AddBookService();
		List<Map<String,Object>> list=service.addBook(book);
		/*
		 * //��list���г�JSON����
		GsonBuilder builder=new GsonBuilder();
		//��ʽ��֮���ٵ���create��������Gsonʵ��
		Gson gson=builder.setDateFormat("yyyy-MM-dd").create();
		//ͨ��gson�������л�list
		String json=gson.toJson(list);
		//ͨ��response���������jsonд�������
		//������response����Ӧ����Ϊjson����
		 */		
		String json=GsonUtil.toJson(list,"yyyy-MM-dd");
		response.setContentType("application/json;charset=utf-8");
		response.getWriter().println(json);
	}
}
