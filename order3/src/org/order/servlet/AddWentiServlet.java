package org.order.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.order.bean.HelpType;
import org.order.bean.HelpWenti;
import org.order.dao.HelpWentiDao;
import org.order.utils.GsonUtil;

import com.google.gson.Gson;

@WebServlet("/admin/adminIndex/addwenti")
public class AddWentiServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			HelpWenti wenti=new HelpWenti();
			wenti.setW_wenti(request.getParameter("wenti"));
			wenti.setW_daan(request.getParameter("daan"));
			HelpType type=new HelpType();
			int w_id=Integer.parseInt(request.getParameter("select"));
			type.setH_id(w_id);
			wenti.setType(type);
			System.out.println(w_id);
			
			HelpWentiDao dao=new HelpWentiDao();
			int i=dao.addType(wenti);
			String msg=i==0?"添加失败":"添加成功";
			System.out.println(msg);
			
			String json=new Gson().toJson(msg);
			response.setContentType("application/json;charset=utf-8");
			response.getWriter().println(json);
	}
}
