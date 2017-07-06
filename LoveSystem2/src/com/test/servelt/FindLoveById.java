package com.test.servelt;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.bean.LoveInHeart;
import com.test.dao.LoveInHeartDao;

/**
 * Servlet implementation class FindLoveById
 */
@WebServlet("/findLoveById")
public class FindLoveById extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindLoveById() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int lid=Integer.parseInt(request.getParameter("lid"));
		LoveInHeartDao dao=new LoveInHeartDao();
		LoveInHeart love=dao.findLoveById(lid);
		request.setAttribute("love", love);
		request.getRequestDispatcher("findLoveById.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(request, response);
	}

}
