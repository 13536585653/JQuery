package com.test.servelt;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.bean.LoveInHeart;
import com.test.util.GsonUtil;

/**
 * Servlet implementation class DeleteLoveServlet
 */
@WebServlet("/deleteLoveServlet")
public class DeleteLoveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteLoveServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] lids=request.getParameterValues("lid");
		DeleteLoveService service=new DeleteLoveService();
		List<LoveInHeart> list=service.remove(lids);
		String json=GsonUtil.toJson(list,"yyyy-MM-dd");
		//使用response响应回客户端
		//将相应类型设置为json类型
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
