package org.front.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.order.bean.PageBean;
import org.order.service.FindJingxuanService;
import org.order.utils.GsonUtil;
@WebServlet("/magashop/findJingxuan")
public class FindJingxuanServlet2 extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//���ܱ����ݹ����ĵ�ǰҳ��
		int pageNum =Integer.parseInt(request.getParameter("pageNum"));
		PageBean pageBean=new PageBean();
		pageBean.setPageNum(pageNum);

		//����ҵ������ҵ�� ����,ͬʱ��pageBean����ҵ�����з�װ����
		FindJingxuanService service=new FindJingxuanService();
		service.findJingxuan(pageBean);
		//��ҵ������֮��,pageBean�ͻ��װ�����еķ�ҳ��Ϣ�ͽ����
		//ֻ��Ҫ������pageBean���л���json�ַ�������
		response.setContentType("application/json;charset=utf-8");
		String json=GsonUtil.toJson(pageBean,"yyyy-MM-dd");
		response.getWriter().println(json);
		System.out.println(json);
		
		
		
		
		/*JingxuanMenuDao dao=new JingxuanMenuDao();
		List<Map<String, Object>> list=dao.findimg();
		String json=new Gson().toJson(list);
		//System.out.println(json);
		//������Ӧ����
		response.setContentType("application/json;charset=utf-8");
		//��Ӧ���
		response.getWriter().println(json);*/
	}
		
}
