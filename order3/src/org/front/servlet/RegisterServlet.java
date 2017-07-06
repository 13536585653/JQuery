package org.front.servlet;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.order.bean.RoleBean;
import org.order.bean.UserBean;
import org.order.dao.UserDao;



/**
 * Servlet implementation class TestServlet
 */
@WebServlet("/magashop/register/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @return 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
			/*UserBean user=BeanUtil.toBean(request.getParameterMap(), UserBean.class);*/
			String uname=request.getParameter("uname");
			String upwd=request.getParameter("upwd");
			String usex=request.getParameter("usex");
			String uaddr=request.getParameter("uaddr");
			String uemail=request.getParameter("uemail");
			String utel=request.getParameter("utel");
			int rtype=1;
			UserBean user =new UserBean();
			user.setUname(uname);
			user.setUpwd(upwd);
			user.setUsex(usex);
			user.setUaddr(uaddr);
			user.setUemail(uemail);
			user.setUtel(utel);
			user.setUmonetary(0);
			user.setU_time(new Timestamp(System.currentTimeMillis()));
			RoleBean role=new RoleBean();
			role.setRid(rtype);
			user.setRtype(role);
			System.out.println(user);
			UserDao dao=new UserDao();
			UserBean newUser=dao.findUserByName(user);
			if(newUser==null){
				int i=dao.addUser(user);
				String json = i==0 ? "注册失败":"注册成功";
				response.setContentType("text/html;charset=utf-8");
				response.getWriter().println(json);
				}
		}
		
	}

