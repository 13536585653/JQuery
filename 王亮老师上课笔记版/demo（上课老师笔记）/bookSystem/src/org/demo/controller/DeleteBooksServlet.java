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
		//���ܲ���
		String[] bids=request.getParameterValues("bid");
		System.out.println("ɾ����ĳ��ȣ�"+bids.length);
		//���������ɸ�ҵ�����д���
		DelBooksService service =new DelBooksService();
		List<Map<String,Object>> list=service.removeBooks(bids);
		//��list���л���json
		String json=GsonUtil.toJson(list,"yyyy-MM-dd");
		response.setContentType("application/json;charset=utf-8");
		response.getWriter().println(json);
	}
}
