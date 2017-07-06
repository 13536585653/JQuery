package org.order.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.GapContent;

import org.order.bean.HelpType;
import org.order.bean.HelpWenti;
import org.order.dao.HelpWentiDao;

import com.google.gson.Gson;
@WebServlet("/admin/adminIndex/updateWenti")
public class UpdateWenti extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("id"));
		String wenti=request.getParameter("wenti");
		String daan=request.getParameter("daan");
		String type=request.getParameter("type");
		int h_id=Integer.parseInt(request.getParameter("h_id"));
		System.out.println(type);
		HelpWenti we=new HelpWenti();
		we.setW_id(id);
		we.setW_wenti(wenti);
		we.setW_daan(daan);
		HelpType type1=new HelpType();
		type1.setH_id(h_id);
		type1.setH_type(type);
		we.setType(type1);
		
		HelpWentiDao dao=new HelpWentiDao();
		int i=dao.updateWenti(we);
		String msg=i==0?"修改失败":"修改成功";
		String json=new Gson().toJson(msg);
		response.setContentType("application/json;charset=utf-8");
		response.getWriter().write(json);
		System.out.println(msg);
	}
}
