package org.order.servlet;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.order.bean.PageBean;
import org.order.service.OrderService;
import org.order.utils.GsonUtil;

@WebServlet("/admin/adminIndex/deleteOrder")
public class DeleteOrder extends HttpServlet{

	/**
	 * 订单的批量删除
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id[]=request.getParameterValues("o_id");
		OrderService service=new OrderService();
		if(id!=null){
			int n[]=service.delete(id);
/*			
		
			String json=GsonUtil.toJson2(list,"yyyy-MM-dd HH:mm:ss");
			response.setContentType("application/json;charset=utf-8");
			response.getWriter().write(json);*/
		}
	}

}
