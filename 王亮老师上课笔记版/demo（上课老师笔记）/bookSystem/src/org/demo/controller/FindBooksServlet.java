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
		//����dao,��ѯ�����鼮��Ϣ
		BookDao dao=new BookDao();
		List<Map<String,Object>> list=dao.findBooks();
		/*//ҳ��ʱajax��������ģ���˽�list���л���json����
		//����Gson�����ڻ��Զ�������ô��������Ҫ�Զ������ڸ�ʽ��ʱ��
		//����ʹ��GsonBuilder��ָ�����ڵĸ�ʽ������
		GsonBuilder builder=new GsonBuilder();
		//��ʽ��֮���ٵ���create��������Gsonʵ��
		Gson gson=builder.setDateFormat("yyyy-MM-dd").create();
		//ͨ��gson�������л�list
		String json=gson.toJson(list);*/
		String json=GsonUtil.toJson(list,"yyyy-MM-dd");
		//ͨ��response���������jsonд�������
		//������response����Ӧ����Ϊjson����
		response.setContentType("application/json;charset=utf-8");
		response.getWriter().println(json);
	}
	
}
