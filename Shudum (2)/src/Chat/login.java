package Chat;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class login
 */
@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=gb2312");
		PrintWriter out=response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>��¼</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<form id=\"form1\" name=\"form1\" method=\"get\" action=\"danmu\">");
		//ע������ʹ��get�������ݵ�Chat
		out.println(" �������������֣�");
		out.println("<input type=\"text\" name=\"username\" id=\"username\" />");
		out.println(" <input type=\"submit\" name=\"button\" id=\"button\" value=\"����������\" />");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
			}

	

}
