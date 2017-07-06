package org.page.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.page.service.FindBookListService;
import org.page.utils.GsonUtil;
import org.page.utils.PageBean;

/**
 * Servlet implementation class FindBookListServlet
 */
@WebServlet("/findBooks")
public class FindBookListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//���ܱ����ݹ����ĵ�ǰҳ��
		int pageNum =Integer.parseInt(request.getParameter("pageNum"));
		PageBean pageBean=new PageBean();
		pageBean.setPageNum(pageNum);
		//����ҵ������ҵ�� ����,ͬʱ��pageBean����ҵ�����з�װ����
		FindBookListService service=new FindBookListService();
		service.findBookList(pageBean);
		//��ҵ������֮��,pageBean�ͻ��װ�����еķ�ҳ��Ϣ�ͽ����
		//ֻ��Ҫ������pageBean���л���json�ַ�������
		response.setContentType("application/json;charset=utf-8");
		String json=GsonUtil.toJson(pageBean,"yyyy-MM-dd");
		response.getWriter().println(json);
	}

}
