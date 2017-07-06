package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Users;
import dao.UsersDao;

/**
 * Servlet implementation class YZMYZ
 */
@WebServlet("/YZMYZ")
public class RegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistServlet() {
        super();
       
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sessions=request.getSession();
		String se = (String) sessions.getAttribute("YZM");
		String mailbox = request.getParameter("email");
		String password = request.getParameter("password");
		String nickname = request.getParameter("nickname");
		int sex = Integer.parseInt(request.getParameter("sex"));
		String YZM = request.getParameter("YZM");
		
		if(YZM.equalsIgnoreCase(se)){
			Users u = new Users();
			
			u.setPassword(password);
			u.setNikename(nickname);		
			u.setSex(sex);
			u.setMailbox(mailbox);
			
			UsersDao ud = new UsersDao();
			
			System.out.println(ud.regist(u));
			if(ud.regist(u)){
				sessions.setAttribute("msg","账号已存在");
				request.getRequestDispatcher("/Register.jsp").forward(request, response);
				
			}else{
				sessions.setAttribute("email",mailbox);
				response.sendRedirect("/Shudum/login.html");
			}
			
		}else{
			sessions.setAttribute("msg","验证码不正确");
			request.getRequestDispatcher("/Register.jsp").forward(request, response);
			}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
