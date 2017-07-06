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
		//获取图片文件名
		List<String> fileNames = (List<String>)request.getSession().getAttribute("fileNames");
		for (String fileName : fileNames) {
			//将文件名保存在作用域中
			request.getSession().setAttribute("fname", fileName);			
		}
		//从作用域中取出文件名
		String fname = (String) request.getSession().getAttribute("fname");
		System.out.println(fname);
		JingxuanMenuBean menu=new JingxuanMenuBean();  //创建实体类
		menu.setM_name(request.getParameter("m_name"));
		Dishes d=new Dishes();
		d.setD_id(Integer.parseInt(request.getParameter("m_type")));
		menu.setType_id(d);
		menu.setTecont(request.getParameter("tecont"));
		menu.setPrice(Float.parseFloat(request.getParameter("price")));
		menu.setFname(fname);
		
		JingxuanMenuDao dao = new JingxuanMenuDao();
		int i=dao.addimg(menu); 
		// 调用添加菜单的dao方法
		
		String json=GsonUtil.toJson(i);
		response.setContentType("html/text;charset=utf-8"); //设置响应格式
		response.getWriter().println(json);  //响应输出
		System.out.println(json);
	}
}
