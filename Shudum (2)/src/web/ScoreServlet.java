package web;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Uidentity;
import dao.UidentityDao;


/**
 * Servlet implementation class ResultServlet
 */
@WebServlet("/score.do")
public class ScoreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public ScoreServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		UidentityDao sd = new UidentityDao();
		HttpSession se = request.getSession();
		
		String mail = (String) se.getAttribute("mail");
		List<Uidentity> list  = sd.getAll();
		
		request.setAttribute("list", list);
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
