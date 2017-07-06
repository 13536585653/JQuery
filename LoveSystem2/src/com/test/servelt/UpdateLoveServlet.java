package com.test.servelt;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.bean.LoveInHeart;
import com.test.dao.LoveInHeartDao;
import com.test.util.GsonUtil;

/**
 * Servlet implementation class UpdateLoveServlet
 */
@WebServlet("/updateLoveServlet")
public class UpdateLoveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateLoveServlet() {
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
		dao.updateLove(love);
		List<LoveInHeart> list=dao.all();
		String json=GsonUtil.toJson(list, "yyyy-MM-dd");
		response.setContentType("application/json;charset=utf-8");
		response.getWriter().write(json);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
