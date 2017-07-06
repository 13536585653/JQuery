package org.order.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.order.bean.HelpType;
import org.order.dao.HelpTypeDao;

import com.google.gson.Gson;
@WebServlet("/admin/adminIndex/updateHelpWenti")
public class UpdateHelpType extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("id"));
		String type=request.getParameter("type");	
		HelpType ty=new HelpType();
		ty.setH_id(id);
		ty.setH_type(type);
		HelpTypeDao dao=new HelpTypeDao();
		int i=dao.updateHelpType(ty);
		String msg=i==0?"修改失败":"修改成功";
		String json=new Gson().toJson(msg);
		response.setContentType("application/json;charset=utf-8");
		response.getWriter().write(json);
		System.out.println(json);
	}
}
