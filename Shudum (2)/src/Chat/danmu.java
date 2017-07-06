package Chat;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DanmuDao;

/**
 * Servlet implementation class danmu
 */
@WebServlet("/danmu")
public class danmu extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public danmu() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("gbk");
		response.setContentType("text/html;charset=gb2312");
		HttpSession session=request.getSession(true);
		String user=(String)session.getAttribute("username");
		DanmuDao dd = new DanmuDao();
		
		// response.setIntHeader("Refresh", 5);
		if (user==null || user.equals(""))
		{
		user=(String)request.getParameter("username");
		if(user==null || user.equals(""))
		{
		//���û����������������ת��LoginChat
		RequestDispatcher dispatcher=getServletConfig().getServletContext().getRequestDispatcher("/login");
		dispatcher.forward(request, response);
		}
		}
		session.setAttribute("username", user);
		//�������ֵ�Session
		PrintWriter out=response.getWriter();
		String words=(String)getServletConfig().getServletContext().getAttribute("Words");
		//��ȡϵͳ��ԭ����ServletContext
		//���ServletContextΪ�գ�������Ϊϵͳ��ʾ����������
		if (words==null)
		{
		getServletConfig().getServletContext().setAttribute("Words", "\n");
		}
		out.println("<html>");
		out.println("<head>");
		out.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">");
		out.println("<title>Insert title here</title>");
//<!-- ��Ļcss -->
		out.println("<link rel=\"stylesheet\" href=\"/Shudum/css/danmu.css\" />");
//<!-- ��Ļcss -->
//<!-- ��Ļscript -->
		out.println("<script type=\"text/javascript\" src=\"jss/jquery-3.0.0.js\" ></script>");

		out.println("<script type=\"text/javascript\" src=\"jss/danmu.js\" ></script>");
//<!-- ��Ļscript -->
		out.println("</head>");
		out.println("<body>");
		//ע������ת��
		//��ʹ��ֱ�����
		//out.println((String)getServletConfig().getServletContext().getAttribute("Words"));
		//ʹ���ı�����ʾ
		//out.println("<div class=\"button1 blue showBarrage\">��Ļ</div>");
		out.println("<div class=\"barrage\">");
		out.println("<div class=\"screen\">");
		out.println("<a href=\"#\" class=\"s_close\">X</a>");
		out.println("<div class=\"mask\"> ");
		//<!--������������ʾ-->
		out.println(" </div>");
		out.println("</div>");
//<!--Send Begin-->
		out.println("<form id=\"form1\" name=\"form1\" method=\"post\" action=\"danmu\">");
		//������Ϣʹ�ñ�ҳ���post
		out.println("<textarea name=\"textarea\" id=\"textarea\" cols=\"100\" rows=\"30\">");
		out.println((String)getServletConfig().getServletContext().getAttribute("Words"));
		out.println("</textarea>");
		out.println("<hr />");
		out.println("<div class=\"send\">");
		out.println("<input type=\"text\"   class=\"s_text1\" name=\"newwords\" id=\"textfield\"  />");
		out.println("<textarea style=\"display:none\" class=\"s_text\"   cols=\"5\"  />"+words+"\n"+"</textarea>");
		out.println("<input type=\"submit\" name=\"button\" class=\"button blue \" id=\"button\" value=\"����\" />");
		out.println("<input  name=\"button\" class=\"button blue s_btn\" id=\"button\" value=\"��Ļ\" />");
		out.println("</div>");
		out.println("</form>");

//<!--Send End-->");
		out.println("<span class=\"s_close\">X</span>");
		out.println("</div>");
		

		out.println("</body>");
		out.println("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("gbk");
		HttpSession session=request.getSession(true);
		//ע��������䣬���򱣴������������ʱ���ܳ�������
		if (request.getParameter("newwords")==null || request.getParameter("newwords").equals(""))
		{
		doGet(request,response);
		}
		else
		{
		String say=new String(session.getAttribute("username").toString().getBytes("ISO-8859-1"),"UTF-8")+"˵:";
		String words=say+request.getParameter("newwords")+"."+"\n"+getServletConfig().getServletContext().getAttribute("Words")+"\n";
		if(words.length()>100){
			words=" ";
		}
		getServletConfig().getServletContext().setAttribute("Words", words);
		doGet(request,response);
		}
	}
}
