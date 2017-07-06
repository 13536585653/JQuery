package com.test.servelt;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.bean.LoveInHeart;
import com.test.dao.LoveInHeartDao;

/**
 * Servlet implementation class AddServlet
 */
@WebServlet("/addServlet")
public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String lname=request.getParameter("lname");
		String lsex=request.getParameter("lsex");
		int lmoney=Integer.parseInt(request.getParameter("lmoney"));
		String ltime=request.getParameter("ltime");
		LoveInHeart love =new LoveInHeart();
		love.setLmoney(lmoney);
		love.setLname(lname);
		love.setLsex(lsex);
		love.setLtime(Date.valueOf(ltime));
		System.out.println(love);
		LoveInHeartDao dao=new LoveInHeartDao();
		int i=dao.add(love);
		String msg=(i==1)?"捐款成功,谢谢支持,祝你幸福安康":"系统故障,操作出错,请重新添加";
		request.setAttribute("msg", msg);
		request.getRequestDispatcher("add.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(request, response);
	}

}
