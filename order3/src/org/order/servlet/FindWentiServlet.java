package org.order.servlet;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.order.bean.PageBean;
import org.order.dao.HelpWentiDao;
import org.order.service.FindWentiService;
import org.order.utils.GsonUtil;

import com.google.gson.Gson;
@WebServlet("/admin/adminIndex/findWenti")
public class FindWentiServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//���ܱ?���ݹ����ĵ�ǰҳ��
				int pageNum =Integer.parseInt(request.getParameter("pageNum"));
				PageBean pageBean=new PageBean();
				pageBean.setPageNum(pageNum);
				//����ҵ������ҵ�� ����,ͬʱ��pageBean����ҵ�����з�װ����
				FindWentiService service=new FindWentiService();
				service.findBookList(pageBean);
				//��ҵ������֮��,pageBean�ͻ��װ�����еķ�ҳ��Ϣ�ͽ��
				//ֻ��Ҫ�����pageBean���л���json�ַ���
				response.setContentType("application/json;charset=utf-8");
				String json=GsonUtil.toJson(pageBean,"yyyy-MM-dd");
				response.getWriter().println(json);
				System.out.println(json);
		
		
//		HelpWentiDao dao=new HelpWentiDao();
//		List<Map<String, Object>> list=dao.FindWenti();
//		String json=new Gson().toJson(list);
//		System.out.println(json);
//		//������Ӧ����
//		response.setContentType("application/json;charset=utf-8");
//		//��Ӧ���
//		response.getWriter().println(json);
		
	}
		
}
