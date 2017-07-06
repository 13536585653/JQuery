package org.order.servlet;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.order.service.DelWentiService;
import org.order.utils.GsonUtil;

import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.order.service.DelJingxuanService;
import org.order.service.DelService;
import org.order.service.DelWentiService;
import org.order.utils.GsonUtil;
@WebServlet("/admin/adminIndex/delJingxuan")
public class DelJingxuanServlet extends HttpServlet{

	/**
	 * 精选菜单的删除
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] mmid=request.getParameterValues("mid");
		//System.out.println("ɾ����ĳ��ȣ�"+mmid.length);
		//���������ɸ�ҵ�����д���
		DelJingxuanService service =new DelJingxuanService();
		int[] list=service.removejingxuan(mmid);
	}
	
}
