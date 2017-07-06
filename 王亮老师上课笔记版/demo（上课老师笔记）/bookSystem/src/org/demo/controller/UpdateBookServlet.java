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
import org.demo.service.UpdateBookService;
import org.demo.utils.GsonUtil;

/**
 * Servlet implementation class UpdateBookServlet
 */
@WebServlet("/updateBook")
public class UpdateBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//���ձ�����Ϣ
		int bid=Integer.parseInt(request.getParameter("bid"));
		String bookName=request.getParameter("bookName");
		Date date=Date.valueOf(request.getParameter("createTime"));
		int tid=Integer.parseInt(request.getParameter("tid"));
		//�����ݷ�װ��bookInfo()
		Book book=new Book();
		book.setBid(bid);
		book.setBname(bookName);
		book.setCreateTime(date);
		book.setTid(tid);
		//���ɸ�ҵ�����д���
		UpdateBookService service=new UpdateBookService();
		List<Map<String,Object>> list=service.update(book);
		//�����صļ������л���json
		String json=GsonUtil.toJson(list,"yyyy-MM-dd");
		//������Ӧ����
		response.setContentType("application/json;charset=utf-8");
		//��Ӧ���
		response.getWriter().println(json);
		System.out.println(json);
	}

}
