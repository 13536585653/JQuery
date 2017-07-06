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
import org.order.service.DelWentiService;
import org.order.utils.GsonUtil;
@WebServlet("/admin/adminIndex/delWenti")
public class DelWentiServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] mmid=request.getParameterValues("mid");
		//System.out.println("ɾ����ĳ��ȣ�"+mmid.length);
		//�������ɸ�ҵ�����д���
		DelWentiService service =new DelWentiService();
		List<Map<String,Object>> list=service.removeWenti(mmid);
		
		String json=GsonUtil.toJson(list);
		response.setContentType("application/json;charset=utf-8");
		response.getWriter().println(json);
	}
}
