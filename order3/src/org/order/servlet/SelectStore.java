package org.order.servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.order.dao.StroeDao;
import org.order.utils.GsonUtil;
@WebServlet("/admin/adminIndex/selectStore")
public class SelectStore extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StroeDao dao=new StroeDao();
		Map<String,Object> map=dao.selectStore();
		String json=GsonUtil.toJson(map);
		response.setContentType("application/json;charset=utf-8");
		response.getWriter().println(json);
		System.out.println(json);
	}

}
