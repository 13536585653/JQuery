package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UsersDao;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public LoginServlet() {
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
		
		String mail = request.getParameter("mail");
		String password = request.getParameter("password");
		
		UsersDao us = new UsersDao();
		String nickname = us.getname(mail);
		if(us.login(mail,password)){
			se.setAttribute("mail",mail);
			se.setAttribute("nickname",nickname);
		}
		
		System.out.println(se.getAttribute("mail"));
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
			
	}
}
