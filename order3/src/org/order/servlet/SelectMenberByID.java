package org.order.servlet;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.order.bean.UserBean;
import org.order.dao.menbersDao;
import org.order.service.UserService;

import com.google.gson.Gson;
@WebServlet("/admin/adminIndex/selectmemberByID")
public class SelectMenberByID extends HttpServlet{

	/**
	 * 通过id查询指定的信息
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ID=request.getParameter("ID");
		if(ID!=null){
			int id=Integer.parseInt(ID);
			UserService service=new UserService();
			Map<String ,Object> map=service.selectById(id);
			String json=new Gson().toJson(map);
			System.out.println(json);
			response.setContentType("application/json;charset=utf-8");
			response.getWriter().write(json);
			System.out.println(json);
		}else{
		int id=Integer.parseInt(request.getParameter("id"));
		UserService service=new UserService();
		
		Map<String ,Object> map =service.selectById(id);
		String json=new Gson().toJson(map);

		response.setContentType("application/json;charset=utf-8");
		response.getWriter().write(json);
		System.out.println(json);
		}
	}

}
