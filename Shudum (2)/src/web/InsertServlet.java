package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UidentityDao;
import dao.UsersDao;

/**
 * Servlet implementation class InsertServlet
 */
@WebServlet("/InsertServlet")
public class InsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public InsertServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		HttpSession se = request.getSession();
		
		String mailbox = (String) se.getAttribute("mail");
		UsersDao us = new UsersDao();
		String nickname = us.getname(mailbox);

		se.setAttribute("nickname",nickname);
		String uidentity = request.getParameter("uidentity");
		
		UidentityDao ud = new UidentityDao();
		
		if(ud.insert(mailbox, uidentity)){
			request.getRequestDispatcher("danmu.jsp").forward(request, response);
		}else{

			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	}

}
