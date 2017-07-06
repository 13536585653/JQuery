package org.order.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.order.dao.HelpTypeDao;
import org.order.utils.GsonUtil;

import com.google.gson.Gson;
@WebServlet("/admin/adminIndex/addType")
public class addHelpType extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String type=request.getParameter("type");
		HelpTypeDao dao=new HelpTypeDao();
		int i=dao.addHelpTypeDao(type);
		//System.out.println(i);
		String msg = i == 0 ? "失败" : "成功";
		System.out.println(msg);
		String json=GsonUtil.toJson(msg);
		response.setContentType("text/html;charset=utf-8");
		//��Ӧ���
		response.getWriter().println(json);
		System.out.println(json);
	}
}
