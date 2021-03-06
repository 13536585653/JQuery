package org.demo.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.demo.dao.LoveDao;
import org.demo.entity.LoveBean;

@WebServlet("/addLoveServlet")
public class AddLoveServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String lname=request.getParameter("lname");
		String lsex=request.getParameter("lsex");
		String ltime=request.getParameter("ltime");
		Date date=Date.valueOf(ltime);
		Double lmoney=Double.valueOf(request.getParameter("lmoney"));
		
		//�����ݷ�װ��LoveBean
		LoveBean love=new LoveBean();
		love.setLname(lname);
		love.setLsex(lsex);
		love.setLtime(date);
		love.setLmoney(lmoney);
		
		//������Ӱ��ĵķ���
		LoveDao dao=new LoveDao();
		int i=dao.addLove(love);
		List<Map<String,Object>> list=dao.findLove();
		request.setAttribute("list", list);
		String msg=i!=0?"����Ѿ��ɹ���лл���֧�֣�ף���Ҹ�������":"ϵͳ���ϣ�����������������ӣ�";
		request.getSession().setAttribute("msg", msg);
		request.getRequestDispatcher("/HTML/index.jsp").forward(request, response);
	}
	
}
