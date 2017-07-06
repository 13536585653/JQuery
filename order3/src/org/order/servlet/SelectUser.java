package org.order.servlet;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.order.bean.PageBean2;
import org.order.bean.UserBean;
import org.order.dao.UsersDao;
import org.order.service.UserService;
import org.order.utils.GsonUtil;

import com.google.gson.Gson;
@WebServlet("/admin/adminIndex/selectuser")
public class SelectUser extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4245700019650880818L;

	/**
	 * 
	 * 查询普通用户
	 */
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		int pageNum =Integer.parseInt(request.getParameter("pageNum"));
		PageBean2 pageBean2=new PageBean2();
		pageBean2.setPageNum(pageNum);
		
		UserService service=new UserService();
		service.findUserList(pageBean2);
		response.setContentType("application/json;charset=utf-8");
		String json=GsonUtil.toJson2(pageBean2,"yyyy-MM-dd HH:mm:ss");
		response.getWriter().println(json);
		System.out.println(json);
		
/*		UserService service=new UserService();
		UsersDao dao=new UsersDao();
		String id=request.getParameter("id");
		if(id!=null){
			int ids=Integer.parseInt(id);
			Map<String ,Object> map=service.selectById(ids);
			String json=new Gson().toJson(map);
			System.out.println(json);
			response.setContentType("application/json;charset=utf-8");
			response.getWriter().write(json);
			System.out.println(json);
		}
		else{
			List<UserBean> list =dao.selectuser();
			String json=new Gson().toJson(list);
			System.out.println(json);
			response.setContentType("application/json;charset=utf-8");
			response.getWriter().write(json);
			System.out.println(json);
		}*/
		
	}

}
