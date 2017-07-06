package org.front.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.order.bean.PageBean2;
import org.order.service.FindMenuService;
import org.order.utils.GsonUtil;
@WebServlet("/order-index/selectmenu")
public class SelectMenu extends HttpServlet{

	/**
	 * 
	 * 鏌ヨ鎵�湁鑿滃崟
	 */
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//���ܱ?���ݹ����ĵ�ǰҳ��
		int pageNum =Integer.parseInt(request.getParameter("pageNum"));
		PageBean2 pageBean2=new PageBean2();
		pageBean2.setPageNum(pageNum);
System.out.println(pageNum);
		//����ҵ������ҵ�� ����,ͬʱ��pageBean����ҵ�����з�װ����
		FindMenuService service=new FindMenuService();
		service.findBookList(pageBean2);
		//��ҵ������֮��,pageBean�ͻ��װ�����еķ�ҳ��Ϣ�ͽ��
		//ֻ��Ҫ�����pageBean���л���json�ַ���
		response.setContentType("application/json;charset=utf-8");
		String json=GsonUtil.toJson(pageBean2,"yyyy-MM-dd");
		response.getWriter().println(json);
		System.out.println(json);

		
		
		
		
		
		
		
		
		
		
		
		
		
	//	MenuDao dao=new MenuDao();
//		MenuService service2=new MenuService();
		//String id=request.getParameter("id");
		//System.out.println(id);
//		if(id!=null){
//			
//			int ids=Integer.parseInt(id);
//			Map<String ,Object> map=service2.select(ids);
//			String json2=new Gson().toJson(map);
//			System.out.println(json2);
//			response.setContentType("application/json;charset=utf-8");
//			response.getWriter().write(json2);
//		}
//		else{
//			List<Map<String ,Object>> list=dao.selectMenu();	
//			String json2=new Gson().toJson(list);
//			response.setContentType("application/json;charset=utf-8");
//			response.getWriter().write(json2);
//			System.out.println(json2);
		
	}

}
