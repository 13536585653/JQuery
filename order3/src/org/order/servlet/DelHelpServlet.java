package org.order.servlet;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.order.service.DelService;
import org.order.utils.GsonUtil;
@WebServlet("/admin/adminIndex/delHelp")
public class DelHelpServlet extends HttpServlet{
			
				@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
					
					String[] mids=request.getParameterValues("mmid");
					System.out.println("gfssga");
					//将参数交由给业务层进行处理
					DelService service =new DelService();
					List<Map<String,Object>> list=service.removeMenus(mids);
					//将list序列化成json
					String json=GsonUtil.toJson(list,"yyyy-MM-dd");
					response.setContentType("application/json;charset=utf-8");
					response.getWriter().println(json);
	}
				
}
