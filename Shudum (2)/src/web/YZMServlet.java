package web;

import java.io.IOException;  
import java.util.Properties;  
import javax.mail.Authenticator;  
import javax.mail.Message.RecipientType;  
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;  
import javax.mail.internet.InternetAddress;  
import javax.mail.internet.MimeMessage;  
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.YZMCode;  

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class YZMServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public YZMServlet() {
        super();
       
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        String toMail = request.getParameter("email");
	        HttpSession sess=request.getSession();
	        
	        
	        System.out.println(toMail);
	        String userName = "13106843196@163.com";  
	         final String password = "aaa1648799618";  
	         Properties props = new Properties();
	 		props.setProperty("mail.host","smtp.163.com" );
	 		props.setProperty("mail.smtp.auth", "true");
	 		
	 		Authenticator auth = new Authenticator(){
	 			@Override
	 			protected PasswordAuthentication getPasswordAuthentication() {
	 				return new PasswordAuthentication("13106843196",password);
	 			}
	 		};
	 		Session session = Session.getInstance(props,auth);
	 		/*
	 		 * 2.创建MimeMessage
	 		 */
	 		MimeMessage msg = new MimeMessage(session);
	 		try {
				msg.setFrom(new InternetAddress(userName));//设置发件人
				msg.setRecipients(RecipientType.TO, toMail);	//设置收件人
			} catch (MessagingException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}		
	 		
	 		try {
	 			String YZM=new YZMCode().getYZM();
	 			System.out.println(YZM);
	 			
	 			sess.setAttribute("YZM", YZM);
				msg.setSubject("这是您的验证码:");
				msg.setContent(YZM,"text/html;charset=UTF-8");
			} catch (MessagingException e1) {
				e1.printStackTrace();
			}
	 		
	 		/*
	 		 * 3.发
	 		 */
	 		try {
				Transport.send(msg);
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	 		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
