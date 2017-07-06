package com.test.servelt;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.dao.LoveInHeartDao;
import com.test.util.GsonUtil;

/**
 * Servlet implementation class FindById
 */
@WebServlet("/findById")
public class FindById extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindById() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int lid=Integer.parseInt(request.getParameter("lid"));
		System.out.println(lid);
		LoveInHeartDao dao=new LoveInHeartDao();
		Map<String,Object> map=dao.findById(lid);
		String json=GsonUtil.toJson(map, "yyyy-MM-dd");
		response.setContentType("application/json;charset=utf-8");
		response.getWriter().write(json);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(request, response);
	}

}
