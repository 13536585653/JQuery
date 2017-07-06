package org.order.servlet;

 
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.order.bean.Dishes;
import org.order.bean.JingxuanMenuBean;
import org.order.dao.JingxuanMenuDao;
import org.order.utils.GsonUtil;


 
@WebServlet("/admin/adminIndex/add")
public class AddJingxuanServlet extends HttpServlet {
 
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		@SuppressWarnings("unchecked")
		//��ȡͼƬ�ļ���
		List<String> fileNames = (List<String>)request.getSession().getAttribute("fileNames");
		for (String fileName : fileNames) {
			//���ļ�����������������
			request.getSession().setAttribute("fname", fileName);			
		}
		//����������ȡ���ļ���
		String fname = (String) request.getSession().getAttribute("fname");
		System.out.println(fname);
		JingxuanMenuBean menu=new JingxuanMenuBean();  //����ʵ����
		menu.setM_name(request.getParameter("m_name"));
		Dishes d=new Dishes();
		d.setD_id(Integer.parseInt(request.getParameter("m_type")));
		menu.setType_id(d);
		menu.setTecont(request.getParameter("tecont"));
		menu.setPrice(Float.parseFloat(request.getParameter("price")));
		menu.setFname(fname);
		
		JingxuanMenuDao dao = new JingxuanMenuDao();
		int i=dao.addimg(menu); 
		// ������Ӳ˵���dao����
		
		String json=GsonUtil.toJson(i);
		response.setContentType("html/text;charset=utf-8"); //������Ӧ��ʽ
		response.getWriter().println(json);  //��Ӧ���
		System.out.println(json);
	}
}
