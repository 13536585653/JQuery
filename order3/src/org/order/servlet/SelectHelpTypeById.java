package org.order.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.order.bean.HelpType;
import org.order.dao.HelpTypeDao;
import org.order.utils.GsonUtil;

import com.google.gson.Gson;
@WebServlet("/admin/adminIndex/selectTypeByid")
public class SelectHelpTypeById extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//System.out.println("aaaaaaaaaaaaaaa");
		int id=Integer.parseInt(request.getParameter("id"));
		//System.out.println(id);
		HelpTypeDao dao=new HelpTypeDao();
		HelpType ty=dao.getHelpTypeById(id);
		String json=new Gson().toJson(ty);
		response.setContentType("application/json;charset=utf-8");
		response.getWriter().println(json);
		System.out.println(json);
	}
}
