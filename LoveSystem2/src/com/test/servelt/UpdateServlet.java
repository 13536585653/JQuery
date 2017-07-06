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
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/updateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int lid=Integer.parseInt(request.getParameter("lid"));
		String lname=request.getParameter("lname");
		String lsex=request.getParameter("lsex");
		int lmoney=Integer.parseInt(request.getParameter("lmoney"));
		String ltime=request.getParameter("ltime");
		LoveInHeart love =new LoveInHeart();
		love.setLid(lid);
		love.setLmoney(lmoney);
		love.setLname(lname);
		love.setLsex(lsex);
		love.setLtime(Date.valueOf(ltime));
		LoveInHeartDao dao=new LoveInHeartDao();
		int i=dao.updateLove(love);
		response.sendRedirect("findLove");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(request, response);
	}

}
