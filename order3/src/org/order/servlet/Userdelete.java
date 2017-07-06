package org.order.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.order.bean.UserBean;
import org.order.service.UserService;
import org.order.utils.GsonUtil;

import com.google.gson.Gson;
@WebServlet("/admin/adminIndex/Userdelete")
public class Userdelete extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2428601970744640000L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String [] s=request.getParameterValues("d_id");
		String id=request.getParameter("Byname");
		UserService service=new  UserService();
		if(s!=null&&id!=null){
		int[] n=service.delete(s,id);
		System.out.println(n.length);
		}else{
			int id1=Integer.parseInt(request.getParameter("id"));
			int id2=Integer.parseInt(request.getParameter("id1"));
		 	int n=service.delete1(id1,id2);
		 	System.out.println(n);
		}
		
	}

}
